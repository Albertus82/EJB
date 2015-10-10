package it.albertus.ejb.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class FilterAdapter implements Filter {

	public void destroy() {}

	public void init(FilterConfig fc) throws ServletException {}

}
