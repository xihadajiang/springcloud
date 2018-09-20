package com.inspur.incloud.common.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.inspur.incloud.common.model.PageBean;
import com.inspur.incloud.common.model.PageListBean;

public class DbPageUtil {
	
	private DbPageUtil() {
        super();
    }
	
	public static PageListBean<?> getPageList(Session session, String countHql, String hql, PageBean page, Object[] args){

        Query q = session.createQuery(hql);
        Query cq = null;
        if (page != null && page.getPageSize() > 0) {
            int pageSize = page.getPageSize();
            int curPage = page.getCurrentPage();
            q.setFirstResult((curPage - 1) * pageSize);
            q.setMaxResults(pageSize);

            cq = session.createQuery(countHql);
        } else {
            cq = null;
        }

        if (args.length > 0) {
            int i = 0;
            while (i < args.length) {
                q.setParameter(i, args[i]);
                if (cq != null) {
                    cq.setParameter(i, args[i]);
                }
                i++;
            }
        }
        List<?> list = q.list();
        int totalNum = 0;
        if (cq != null) {
            totalNum = ((Number) cq.iterate().next()).intValue();
        } else {
            totalNum = list.size();
        }
        if (page == null) {
            page = new PageBean(1, 1, "", "asc");
        }
        PageListBean<?> plb = new PageListBean(totalNum, page, list);
        return plb;
    }
	

}
