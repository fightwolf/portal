package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.read;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample.Criteria;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample.Criterion;

import java.util.List;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PortalNoticeSqlProvider {

    public String countByExample(PortalNoticeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`portal_notice`");
        applyWhere(example, false);
        return SQL();
    }

    public String selectByExampleWithBLOBs(PortalNoticeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`Id`");
        } else {
            SELECT("`Id`");
        }
        SELECT("`title`");
        SELECT("`sub_title`");
        SELECT("`position_id`");
        SELECT("`position_name`");
        SELECT("`icon`");
        SELECT("`link`");
        SELECT("`begin_times`");
        SELECT("`end_times`");
        SELECT("`ar`");
        SELECT("`status`");
        SELECT("`creator_id`");
        SELECT("`creator_name`");
        SELECT("`create_timestamp`");
        SELECT("`last_update_timestamp`");
        SELECT("`contents`");
        FROM("`portal_notice`");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        String returnValue = SQL();
        if (example != null && example.getPageIndex() != null && example.getPageCount() != null) {
            int pageCount = example.getPageCount();
            int pageStart = (example.getPageIndex() - 1) * pageCount;
            returnValue += String.format(" limit %1$d,%2$d", pageStart, pageCount);
        }
        return returnValue;
    }

    public String selectByExample(PortalNoticeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`Id`");
        } else {
            SELECT("`Id`");
        }
        SELECT("`title`");
        SELECT("`sub_title`");
        SELECT("`position_id`");
        SELECT("`position_name`");
        SELECT("`icon`");
        SELECT("`link`");
        SELECT("`begin_times`");
        SELECT("`end_times`");
        SELECT("`ar`");
        SELECT("`status`");
        SELECT("`creator_id`");
        SELECT("`creator_name`");
        SELECT("`create_timestamp`");
        SELECT("`last_update_timestamp`");
        FROM("`portal_notice`");
        applyWhere(example, false);

        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }

        String returnValue = SQL();
        if (example != null && example.getPageIndex() != null && example.getPageCount() != null) {
            int pageCount = example.getPageCount();
            int pageStart = (example.getPageIndex() - 1) * pageCount;
            returnValue += String.format(" limit %1$d,%2$d", pageStart, pageCount);
        }
        return returnValue;
    }

    protected void applyWhere(PortalNoticeExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }

        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }

        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }

                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }

                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }

        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}