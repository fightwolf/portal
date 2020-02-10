package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRoles;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample.Criteria;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalRolesExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PortalRolesSqlProvider {

    public String deleteByExample(PortalRolesExample example) {
        BEGIN();
        DELETE_FROM("`portal_roles`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PortalRoles record) {
        BEGIN();
        INSERT_INTO("`portal_roles`");

        if (record.getId() != null) {
            VALUES("`Id`", "#{id,jdbcType=BIGINT}");
        }

        if (record.getRoleCode() != null) {
            VALUES("`role_code`", "#{roleCode,jdbcType=VARCHAR}");
        }

        if (record.getRoleName() != null) {
            VALUES("`role_name`", "#{roleName,jdbcType=VARCHAR}");
        }

        if (record.getAr() != null) {
            VALUES("`ar`", "#{ar,jdbcType=INTEGER}");
        }

        if (record.getDescribes() != null) {
            VALUES("`describes`", "#{describes,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=INTEGER}");
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
        PortalRoles record = (PortalRoles) parameter.get("record");
        PortalRolesExample example = (PortalRolesExample) parameter.get("example");

        BEGIN();
        UPDATE("`portal_roles`");

        if (record.getId() != null) {
            SET("`Id` = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getRoleCode() != null) {
            SET("`role_code` = #{record.roleCode,jdbcType=VARCHAR}");
        }

        if (record.getRoleName() != null) {
            SET("`role_name` = #{record.roleName,jdbcType=VARCHAR}");
        }

        if (record.getAr() != null) {
            SET("`ar` = #{record.ar,jdbcType=INTEGER}");
        }

        if (record.getDescribes() != null) {
            SET("`describes` = #{record.describes,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=INTEGER}");
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
        UPDATE("`portal_roles`");

        SET("`Id` = #{record.id,jdbcType=BIGINT}");
        SET("`role_code` = #{record.roleCode,jdbcType=VARCHAR}");
        SET("`role_name` = #{record.roleName,jdbcType=VARCHAR}");
        SET("`ar` = #{record.ar,jdbcType=INTEGER}");
        SET("`describes` = #{record.describes,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");

        PortalRolesExample example = (PortalRolesExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PortalRoles record) {
        BEGIN();
        UPDATE("`portal_roles`");

        if (record.getRoleCode() != null) {
            SET("`role_code` = #{roleCode,jdbcType=VARCHAR}");
        }

        if (record.getRoleName() != null) {
            SET("`role_name` = #{roleName,jdbcType=VARCHAR}");
        }

        if (record.getAr() != null) {
            SET("`ar` = #{ar,jdbcType=INTEGER}");
        }

        if (record.getDescribes() != null) {
            SET("`describes` = #{describes,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=INTEGER}");
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

    protected void applyWhere(PortalRolesExample example, boolean includeExamplePhrase) {
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