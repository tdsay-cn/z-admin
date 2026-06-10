package com.z.admin.entity.convert;

import com.z.admin.entity.dto.PermissionTreeDto;
import com.z.admin.entity.vo.system.PermissionTreeNodeVo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Permission DTO to VO mapper
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionConvert {

    /**
     * Convert PermissionTreeDto to PermissionTreeNodeVo
     */
    PermissionTreeNodeVo toTreeNodeVo(PermissionTreeDto dto);

    /**
     * Convert list of PermissionTreeDto to list of PermissionTreeNodeVo
     */
    List<PermissionTreeNodeVo> toTreeNodeVoList(List<PermissionTreeDto> dtoList);
}
