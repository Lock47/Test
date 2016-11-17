package com.logistics.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.logistics.model.UserInfo;

public class MemberInterceptor implements HandlerInterceptor
{
	//���徲̬��session����
    public final static String SESSION_MEMBER="UserSession";
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	//����mvc.xml���õ�/Admin/**·��������
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception
	{
		// TODO Auto-generated method stub
		//����·��
		String contextPath=request.getContextPath();
		String url=request.getServletPath().toString();
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo) session.getAttribute(SESSION_MEMBER);
		//�ж�session�Ƿ�Ϊ��������ͬҳ�棨Ҳ���Խ��û���Ϣ����session��
		//Ȼ��ȡ�û���Ȩ����Ϣ������Ȩ���ж���תָ��ҳ�棩
		if(user==null)
		{
			//�����أ��ض���loginҳ��
			response.sendRedirect(contextPath+"/login?redirectURL="+URLEncoder.encode(url));
			return false;
		}
		
		return true;
	}

}
