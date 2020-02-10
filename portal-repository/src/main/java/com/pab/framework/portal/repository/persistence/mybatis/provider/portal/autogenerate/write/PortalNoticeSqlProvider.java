package com.pab.framework.portal.repository.persistence.mybatis.provider.portal.autogenerate.write;

import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNotice;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample.Criteria;
import com.pab.framework.portal.repository.persistence.mybatis.entity.portal.PortalNoticeExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class PortalNoticeSqlProvider {

    public String deleteByExample(PortalNoticeExample example) {
        BEGIN();
        DELETE_FROM("`portal_notice`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(PortalNotice record) {
        BEGIN();
        INSERT_INTO("`portal_notice`");

        if (record.getId() != null) {
            VALUES("`Id`", "#{id,jdbcType=BIGINT}");
        }

        if (record.getTitle() != null) {
            VALUES("`title`", "#{title,jdbcType=VARCHAR}");
        }

        if (record.getSubTitle() != null) {
            VALUES("`sub_title`", "#{subTitle,jdbcType=VARCHAR}");
        }

        if (record.getPositionId() != null) {
            VALUES("`position_id`", "#{positionId,jdbcType=INTEGER}");
        }

        if (record.getPositionName() != null) {
            VALUES("`position_name`", "#{positionName,jdbcType=VARCHAR}");
        }

        if (record.getIcon() != null) {
            VALUES("`icon`", "#{icon,jdbcType=VARCHAR}");
        }

        if (record.getLink() != null) {
            VALUES("`link`", "#{link,jdbcType=VARCHAR}");
        }

        if (record.getBeginTimes() != null) {
            VALUES("`begin_times`", "#{beginTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getEndTimes() != null) {
            VALUES("`end_times`", "#{endTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getAr() != null) {
            VALUES("`ar`", "#{ar,jdbcType=INTEGER}");
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

        if (record.getContents() != null) {
            VALUES("`contents`", "#{contents,jdbcType=LONGVARBINARY}");
        }

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PortalNotice record = (PortalNotice) parameter.get("record");
        PortalNoticeExample example = (PortalNoticeExample) parameter.get("example");

        BEGIN();
        UPDATE("`portal_notice`");

        if (record.getId() != null) {
            SET("`Id` = #{record.id,jdbcType=BIGINT}");
        }

        if (record.getTitle() != null) {
            SET("`title` = #{record.title,jdbcType=VARCHAR}");
        }

        if (record.getSubTitle() != null) {
            SET("`sub_title` = #{record.subTitle,jdbcType=VARCHAR}");
        }

        if (record.getPositionId() != null) {
            SET("`position_id` = #{record.positionId,jdbcType=INTEGER}");
        }

        if (record.getPositionName() != null) {
            SET("`position_name` = #{record.positionName,jdbcType=VARCHAR}");
        }

        if (record.getIcon() != null) {
            SET("`icon` = #{record.icon,jdbcType=VARCHAR}");
        }

        if (record.getLink() != null) {
            SET("`link` = #{record.link,jdbcType=VARCHAR}");
        }

        if (record.getBeginTimes() != null) {
            SET("`begin_times` = #{record.beginTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getEndTimes() != null) {
            SET("`end_times` = #{record.endTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getAr() != null) {
            SET("`ar` = #{record.ar,jdbcType=INTEGER}");
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

        if (record.getContents() != null) {
            SET("`contents` = #{record.contents,jdbcType=LONGVARBINARY}");
        }

        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`portal_notice`");

        SET("`Id` = #{record.id,jdbcType=BIGINT}");
        SET("`title` = #{record.title,jdbcType=VARCHAR}");
        SET("`sub_title` = #{record.subTitle,jdbcType=VARCHAR}");
        SET("`position_id` = #{record.positionId,jdbcType=INTEGER}");
        SET("`position_name` = #{record.positionName,jdbcType=VARCHAR}");
        SET("`icon` = #{record.icon,jdbcType=VARCHAR}");
        SET("`link` = #{record.link,jdbcType=VARCHAR}");
        SET("`begin_times` = #{record.beginTimes,jdbcType=TIMESTAMP}");
        SET("`end_times` = #{record.endTimes,jdbcType=TIMESTAMP}");
        SET("`ar` = #{record.ar,jdbcType=INTEGER}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");
        SET("`contents` = #{record.contents,jdbcType=LONGVARBINARY}");

        PortalNoticeExample example = (PortalNoticeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`portal_notice`");

        SET("`Id` = #{record.id,jdbcType=BIGINT}");
        SET("`title` = #{record.title,jdbcType=VARCHAR}");
        SET("`sub_title` = #{record.subTitle,jdbcType=VARCHAR}");
        SET("`position_id` = #{record.positionId,jdbcType=INTEGER}");
        SET("`position_name` = #{record.positionName,jdbcType=VARCHAR}");
        SET("`icon` = #{record.icon,jdbcType=VARCHAR}");
        SET("`link` = #{record.link,jdbcType=VARCHAR}");
        SET("`begin_times` = #{record.beginTimes,jdbcType=TIMESTAMP}");
        SET("`end_times` = #{record.endTimes,jdbcType=TIMESTAMP}");
        SET("`ar` = #{record.ar,jdbcType=INTEGER}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`creator_id` = #{record.creatorId,jdbcType=VARCHAR}");
        SET("`creator_name` = #{record.creatorName,jdbcType=VARCHAR}");

        PortalNoticeExample example = (PortalNoticeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(PortalNotice record) {
        BEGIN();
        UPDATE("`portal_notice`");

        if (record.getTitle() != null) {
            SET("`title` = #{title,jdbcType=VARCHAR}");
        }

        if (record.getSubTitle() != null) {
            SET("`sub_title` = #{subTitle,jdbcType=VARCHAR}");
        }

        if (record.getPositionId() != null) {
            SET("`position_id` = #{positionId,jdbcType=INTEGER}");
        }

        if (record.getPositionName() != null) {
            SET("`position_name` = #{positionName,jdbcType=VARCHAR}");
        }

        if (record.getIcon() != null) {
            SET("`icon` = #{icon,jdbcType=VARCHAR}");
        }

        if (record.getLink() != null) {
            SET("`link` = #{link,jdbcType=VARCHAR}");
        }

        if (record.getBeginTimes() != null) {
            SET("`begin_times` = #{beginTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getEndTimes() != null) {
            SET("`end_times` = #{endTimes,jdbcType=TIMESTAMP}");
        }

        if (record.getAr() != null) {
            SET("`ar` = #{ar,jdbcType=INTEGER}");
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

        if (record.getContents() != null) {
            SET("`contents` = #{contents,jdbcType=LONGVARBINARY}");
        }

        WHERE("`Id` = #{id,jdbcType=BIGINT}");

        return SQL();
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