package it.albertus.ejb.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class FilterAdapter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig fc) throws ServletException {}

}
