package com.example.graphql.demo.model.api;

public enum DSVSourceTypeEnum {
    large_scale_study("large scale study"), uniprot("uniprot"), mixed("mixed");
    private String sourceName;
    DSVSourceTypeEnum(String sourceName) {
        this.sourceName = sourceName;
    }
    public static DSVSourceTypeEnum getVariantSourceTypeEnum(String sourceName) {
        DSVSourceTypeEnum result = null;
        for (DSVSourceTypeEnum item : DSVSourceTypeEnum.values()) {
            if (item.sourceName.equalsIgnoreCase(sourceName) || item.name().equalsIgnoreCase(sourceName)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

