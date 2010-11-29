package com.billy.bob.server.request;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GwtRpcDispatcher extends RemoteServiceServlet implements Controller, ServletContextAware{
	private RemoteService remoteService;
	private ServletContext servletContext;
	
	public void setRemoteService(RemoteService remoteService){
		this.remoteService = remoteService;
	}
	
	public String processCall(String payload) throws SerializationException {
		try{
			RPCRequest rpcRequest = RPC.decodeRequest(payload, this.remoteService.getClass());
			GwtRpcDispatcherUtil.setThreadLocals(getThreadLocalRequest(), getThreadLocalResponse(), getServletContext());
			return RPC.invokeAndEncodeResponse(this.remoteService, rpcRequest.getMethod(), rpcRequest.getParameters());
		}
		catch (IncompatibleRemoteServiceException e){
			return RPC.encodeResponseForFailure(null, e);
		}
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		doPost(request, response);
		return null; // response handled by GWT RPC over XmlHttpRequest
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public ServletContext getServletContext(){
		return servletContext;
	}
	
}
