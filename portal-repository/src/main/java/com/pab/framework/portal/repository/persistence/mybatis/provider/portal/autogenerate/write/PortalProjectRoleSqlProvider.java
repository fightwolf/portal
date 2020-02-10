package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRole;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample.Criteria;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalProjectRoleExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PortalProjectRoleSqlProvider {

    public String deleteByExample(PortalProjectRoleExample example) {
        BEGIN();
        DELETE_FROM("`portal_project_role`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PortalProjectRole record) {
        BEGIN();
        INSERT_INTO("`portal_project_role`");

        if (record.getId() != null) {
            VALUES("`Id`", "#{id,jdbcType=BIGINT}");
        }

        if (record.getRoleCode() != null) {
            VALUES("`role_code`", "#{roleCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectCode() != null) {
            VALUES("`project_code`", "#{projectCode,jdbcType=VARCHAR}");
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
        PortalProjectRole record = (PortalProjectRole) parameter.get("record");
        PortalProjectRoleExample example = (PortalProjectRoleExample) parameter.get("example");

        BEGIN();
        UPDATE("`portal_project_role`");

        if (record.getId() != null) {
            SET("`Id` = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getRoleCode() != null) {
            SET("`role_code` = #{record.roleCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectCode() != null) {
            SET("`project_code` = #{record.projectCode,jdbcType=VARCHAR}");
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
        UPDATE("`portal_project_role`");

        SET("`Id` = #{record.id,jdbcType=BIGINT}");
        SET("`role_code` = #{record.roleCode,jdbcType=VARCHAR}");
        SET("`project_code` = #{record.projectCode,jdbcType=VARCHAR}");
        SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");

        PortalProjectRoleExample example = (PortalProjectRoleExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PortalProjectRole record) {
        BEGIN();
        UPDATE("`portal_project_role`");

        if (record.getRoleCode() != null) {
            SET("`role_code` = #{roleCode,jdbcType=VARCHAR}");
        }

        if (record.getProjectCode() != null) {
            SET("`project_code` = #{projectCode,jdbcType=VARCHAR}");
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

    protected void applyWhere(PortalProjectRoleExample example, boolean includeExamplePhrase) {
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