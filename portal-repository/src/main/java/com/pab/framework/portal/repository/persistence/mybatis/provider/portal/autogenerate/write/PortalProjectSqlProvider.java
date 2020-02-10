package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProject;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample.Criteria;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PortalProjectSqlProvider {

    public String deleteByExample(PortalProjectExample example) {
        BEGIN();
        DELETE_FROM("`portal_project`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PortalProject record) {
        BEGIN();
        INSERT_INTO("`portal_project`");

        if (record.getId() != null) {
            VALUES("`Id`", "#{id,jdbcType=BIGINT}");
        }

        if (record.getProjectCode() != null) {
            VALUES("`project_code`", "#{projectCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectName() != null) {
            VALUES("`project_name`", "#{projectName,jdbcType=VARCHAR}");
        }

        if (record.getProjectType() != null) {
            VALUES("`project_type`", "#{projectType,jdbcType=INTEGER}");
        }

        if (record.getParentCode() != null) {
            VALUES("`parent_code`", "#{parentCode,jdbcType=VARCHAR}");
        }

        if (record.getUrl() != null) {
            VALUES("`url`", "#{url,jdbcType=VARCHAR}");
        }

        if (record.getUrlName() != null) {
            VALUES("`url_name`", "#{urlName,jdbcType=VARCHAR}");
        }

        if (record.getDescribes() != null) {
            VALUES("`describes`", "#{describes,jdbcType=VARCHAR}");
        }

        if (record.getCreatorId() != null) {
            VALUES("`creator_id`", "#{creatorId,jdbcType=VARCHAR}");
        }

        if (record.getCreatorName() != null) {
            VALUES("`creator_name`", "#{creatorName,jdbcType=VARCHAR}");
        }

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PortalProject record = (PortalProject) parameter.get("record");
        PortalProjectExample example = (PortalProjectExample) parameter.get("example");

        BEGIN();
        UPDATE("`portal_project`");

        if (record.getId() != null) {
            SET("`Id` = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getProjectCode() != null) {
            SET("`project_code` = #{record.projectCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectName() != null) {
            SET("`project_name` = #{record.projectName,jdbcType=VARCHAR}");
        }

        if (record.getProjectType() != null) {
            SET("`project_type` = #{record.projectType,jdbcType=INTEGER}");
        }

        if (record.getParentCode() != null) {
            SET("`parent_code` = #{record.parentCode,jdbcType=VARCHAR}");
        }

        if (record.getUrl() != null) {
            SET("`url` = #{record.url,jdbcType=VARCHAR}");
        }

        if (record.getUrlName() != null) {
            SET("`url_name` = #{record.urlName,jdbcType=VARCHAR}");
        }

        if (record.getDescribes() != null) {
            SET("`describes` = #{record.describes,jdbcType=VARCHAR}");
        }

        if (record.getCreatorId() != null) {
            SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        }

        if (record.getCreatorName() != null) {
            SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");
        }

        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`portal_project`");

        SET("`Id` = #{record.id,jdbcType=BIGINT}");
        SET("`project_code` = #{record.projectCode,jdbcType=VARCHAR}");
        SET("`project_name` = #{record.projectName,jdbcType=VARCHAR}");
        SET("`project_type` = #{record.projectType,jdbcType=INTEGER}");
        SET("`parent_code` = #{record.parentCode,jdbcType=VARCHAR}");
        SET("`url` = #{record.url,jdbcType=VARCHAR}");
        SET("`url_name` = #{record.urlName,jdbcType=VARCHAR}");
        SET("`describes` = #{record.describes,jdbcType=VARCHAR}");
        SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");

        PortalProjectExample example = (PortalProjectExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PortalProject record) {
        BEGIN();
        UPDATE("`portal_project`");

        if (record.getProjectCode() != null) {
            SET("`project_code` = #{projectCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectName() != null) {
            SET("`project_name` = #{projectName,jdbcType=VARCHAR}");
        }

        if (record.getProjectType() != null) {
            SET("`project_type` = #{projectType,jdbcType=INTEGER}");
        }

        if (record.getParentCode() != null) {
            SET("`parent_code` = #{parentCode,jdbcType=VARCHAR}");
        }

        if (record.getUrl() != null) {
            SET("`url` = #{url,jdbcType=VARCHAR}");
        }

        if (record.getUrlName() != null) {
            SET("`url_name` = #{urlName,jdbcType=VARCHAR}");
        }

        if (record.getDescribes() != null) {
            SET("`describes` = #{describes,jdbcType=VARCHAR}");
        }

        if (record.getCreatorId() != null) {
            SET("`creator_id` = #{creatorId,jdbcType=VARCHAR}");
        }

        if (record.getCreatorName() != null) {
            SET("`creator_name` = #{creatorName,jdbcType=VARCHAR}");
        }

        WHERE("`Id` = #{id,jdbcType=BIGINT}");

        return SQL();
    }

    protected void applyWhere(PortalProjectExample example, boolean includeExamplePhrase) {
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