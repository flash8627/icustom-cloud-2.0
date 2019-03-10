package com.gwtjs.icustom.security.entity;

public class ForecastVO {

	private Integer forecastHeaderId; // 预测头id
	private Integer demandEntityId; // 需求主体id
	private String pdtType; // 预测对象类型(coarse/fine)
	private String pdtId; // 预测对象id(远粗对象和近细对象id)
	private Integer supplyEntityId; // 供应主体id
	private String demandEntityCode;
	/* dwx312100 add */
	private String areaOrgName;
	private String areaOrgCode;

	private String forecastStatus; // 预测状态(draft/submit)
	private String deleteFlag; // 删除标识(y/n)
	private String period; // 期

	private String planCodeQueryYN;// 是否按计划员编码查询 （默认查询）

	private String pdtSmallCode; // 细对象code
	private String pdtSmallNameCn;// 细对象名称
	private String pdtSmallNameEn;//
	private String pdtSmallUom;// 细对象单位

	private Integer pdtLargeId; // 远粗对象id

	private String lv0OrgCode;
	private String lv1OrgCode;
	private String lv2OrgCode;
	private String lv3OrgCode;
	private String lv4OrgCode;
	private String lv0OrgNameCn;
	private String lv0OrgNameEn;
	private String lv1OrgNameCn;
	private String lv1OrgNameEn;
	private String lv2OrgNameCn;
	private String lv2OrgNameEn;
	private String lv3OrgNameCn;
	private String lv3OrgNameEn;
	private String lv4OrgNameCn;
	private String lv4OrgNameEn;
	private String lv0TypeName;
	private String lv1TypeName;
	private String lv2TypeName;
	private String lv3TypeName;
	private String lv4TypeName;
	private String pdtLargeCode;//
	private String pdtLargeNameCn;
	private String pdtLargeNameEn;
	private String pdtLargeUom;

	private String[] lv0OrgCodes;
	private String[] lv1OrgCodes;
	private String[] lv2OrgCodes;
	private String[] lv3OrgCodes;
	private String[] lv4OrgCodes;
	private String[] pdtLargeCodes;
	private String[] pdtSmallCodes;

	private Double bucket1;
	private Double bucket2;
	private Double bucket3;
	private Double bucket4;
	private Double bucket5;
	private Double bucket6;
	private Double bucket7;
	private Double bucket8;
	private Double bucket9;
	private Double bucket10;

	private Double bucket11;
	private Double bucket12;
	private Double bucket13;
	private Double bucket14;
	private Double bucket15;
	private Double bucket16;
	private Double bucket17;
	private Double bucket18;
	private Double bucket19;
	private Double bucket20;

	private Double bucket21;
	private Double bucket22;
	private Double bucket23;
	private Double bucket24;
	private Double bucket25;
	private Double bucket26;
	private Double bucket27;
	private Double bucket28;
	private Double bucket29;
	private Double bucket30;
	public Integer getForecastHeaderId() {
		return forecastHeaderId;
	}
	public void setForecastHeaderId(Integer forecastHeaderId) {
		this.forecastHeaderId = forecastHeaderId;
	}
	public Integer getDemandEntityId() {
		return demandEntityId;
	}
	public void setDemandEntityId(Integer demandEntityId) {
		this.demandEntityId = demandEntityId;
	}
	public String getPdtType() {
		return pdtType;
	}
	public void setPdtType(String pdtType) {
		this.pdtType = pdtType;
	}
	public String getPdtId() {
		return pdtId;
	}
	public void setPdtId(String pdtId) {
		this.pdtId = pdtId;
	}
	public Integer getSupplyEntityId() {
		return supplyEntityId;
	}
	public void setSupplyEntityId(Integer supplyEntityId) {
		this.supplyEntityId = supplyEntityId;
	}
	public String getDemandEntityCode() {
		return demandEntityCode;
	}
	public void setDemandEntityCode(String demandEntityCode) {
		this.demandEntityCode = demandEntityCode;
	}
	public String getAreaOrgName() {
		return areaOrgName;
	}
	public void setAreaOrgName(String areaOrgName) {
		this.areaOrgName = areaOrgName;
	}
	public String getAreaOrgCode() {
		return areaOrgCode;
	}
	public void setAreaOrgCode(String areaOrgCode) {
		this.areaOrgCode = areaOrgCode;
	}
	public String getForecastStatus() {
		return forecastStatus;
	}
	public void setForecastStatus(String forecastStatus) {
		this.forecastStatus = forecastStatus;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPlanCodeQueryYN() {
		return planCodeQueryYN;
	}
	public void setPlanCodeQueryYN(String planCodeQueryYN) {
		this.planCodeQueryYN = planCodeQueryYN;
	}
	public String getPdtSmallCode() {
		return pdtSmallCode;
	}
	public void setPdtSmallCode(String pdtSmallCode) {
		this.pdtSmallCode = pdtSmallCode;
	}
	public String getPdtSmallNameCn() {
		return pdtSmallNameCn;
	}
	public void setPdtSmallNameCn(String pdtSmallNameCn) {
		this.pdtSmallNameCn = pdtSmallNameCn;
	}
	public String getPdtSmallNameEn() {
		return pdtSmallNameEn;
	}
	public void setPdtSmallNameEn(String pdtSmallNameEn) {
		this.pdtSmallNameEn = pdtSmallNameEn;
	}
	public String getPdtSmallUom() {
		return pdtSmallUom;
	}
	public void setPdtSmallUom(String pdtSmallUom) {
		this.pdtSmallUom = pdtSmallUom;
	}
	public Integer getPdtLargeId() {
		return pdtLargeId;
	}
	public void setPdtLargeId(Integer pdtLargeId) {
		this.pdtLargeId = pdtLargeId;
	}
	public String getLv0OrgCode() {
		return lv0OrgCode;
	}
	public void setLv0OrgCode(String lv0OrgCode) {
		this.lv0OrgCode = lv0OrgCode;
	}
	public String getLv1OrgCode() {
		return lv1OrgCode;
	}
	public void setLv1OrgCode(String lv1OrgCode) {
		this.lv1OrgCode = lv1OrgCode;
	}
	public String getLv2OrgCode() {
		return lv2OrgCode;
	}
	public void setLv2OrgCode(String lv2OrgCode) {
		this.lv2OrgCode = lv2OrgCode;
	}
	public String getLv3OrgCode() {
		return lv3OrgCode;
	}
	public void setLv3OrgCode(String lv3OrgCode) {
		this.lv3OrgCode = lv3OrgCode;
	}
	public String getLv4OrgCode() {
		return lv4OrgCode;
	}
	public void setLv4OrgCode(String lv4OrgCode) {
		this.lv4OrgCode = lv4OrgCode;
	}
	public String getLv0OrgNameCn() {
		return lv0OrgNameCn;
	}
	public void setLv0OrgNameCn(String lv0OrgNameCn) {
		this.lv0OrgNameCn = lv0OrgNameCn;
	}
	public String getLv0OrgNameEn() {
		return lv0OrgNameEn;
	}
	public void setLv0OrgNameEn(String lv0OrgNameEn) {
		this.lv0OrgNameEn = lv0OrgNameEn;
	}
	public String getLv1OrgNameCn() {
		return lv1OrgNameCn;
	}
	public void setLv1OrgNameCn(String lv1OrgNameCn) {
		this.lv1OrgNameCn = lv1OrgNameCn;
	}
	public String getLv1OrgNameEn() {
		return lv1OrgNameEn;
	}
	public void setLv1OrgNameEn(String lv1OrgNameEn) {
		this.lv1OrgNameEn = lv1OrgNameEn;
	}
	public String getLv2OrgNameCn() {
		return lv2OrgNameCn;
	}
	public void setLv2OrgNameCn(String lv2OrgNameCn) {
		this.lv2OrgNameCn = lv2OrgNameCn;
	}
	public String getLv2OrgNameEn() {
		return lv2OrgNameEn;
	}
	public void setLv2OrgNameEn(String lv2OrgNameEn) {
		this.lv2OrgNameEn = lv2OrgNameEn;
	}
	public String getLv3OrgNameCn() {
		return lv3OrgNameCn;
	}
	public void setLv3OrgNameCn(String lv3OrgNameCn) {
		this.lv3OrgNameCn = lv3OrgNameCn;
	}
	public String getLv3OrgNameEn() {
		return lv3OrgNameEn;
	}
	public void setLv3OrgNameEn(String lv3OrgNameEn) {
		this.lv3OrgNameEn = lv3OrgNameEn;
	}
	public String getLv4OrgNameCn() {
		return lv4OrgNameCn;
	}
	public void setLv4OrgNameCn(String lv4OrgNameCn) {
		this.lv4OrgNameCn = lv4OrgNameCn;
	}
	public String getLv4OrgNameEn() {
		return lv4OrgNameEn;
	}
	public void setLv4OrgNameEn(String lv4OrgNameEn) {
		this.lv4OrgNameEn = lv4OrgNameEn;
	}
	public String getLv0TypeName() {
		return lv0TypeName;
	}
	public void setLv0TypeName(String lv0TypeName) {
		this.lv0TypeName = lv0TypeName;
	}
	public String getLv1TypeName() {
		return lv1TypeName;
	}
	public void setLv1TypeName(String lv1TypeName) {
		this.lv1TypeName = lv1TypeName;
	}
	public String getLv2TypeName() {
		return lv2TypeName;
	}
	public void setLv2TypeName(String lv2TypeName) {
		this.lv2TypeName = lv2TypeName;
	}
	public String getLv3TypeName() {
		return lv3TypeName;
	}
	public void setLv3TypeName(String lv3TypeName) {
		this.lv3TypeName = lv3TypeName;
	}
	public String getLv4TypeName() {
		return lv4TypeName;
	}
	public void setLv4TypeName(String lv4TypeName) {
		this.lv4TypeName = lv4TypeName;
	}
	public String getPdtLargeCode() {
		return pdtLargeCode;
	}
	public void setPdtLargeCode(String pdtLargeCode) {
		this.pdtLargeCode = pdtLargeCode;
	}
	public String getPdtLargeNameCn() {
		return pdtLargeNameCn;
	}
	public void setPdtLargeNameCn(String pdtLargeNameCn) {
		this.pdtLargeNameCn = pdtLargeNameCn;
	}
	public String getPdtLargeNameEn() {
		return pdtLargeNameEn;
	}
	public void setPdtLargeNameEn(String pdtLargeNameEn) {
		this.pdtLargeNameEn = pdtLargeNameEn;
	}
	public String getPdtLargeUom() {
		return pdtLargeUom;
	}
	public void setPdtLargeUom(String pdtLargeUom) {
		this.pdtLargeUom = pdtLargeUom;
	}
	public String[] getLv0OrgCodes() {
		return lv0OrgCodes;
	}
	public void setLv0OrgCodes(String[] lv0OrgCodes) {
		this.lv0OrgCodes = lv0OrgCodes;
	}
	public String[] getLv1OrgCodes() {
		return lv1OrgCodes;
	}
	public void setLv1OrgCodes(String[] lv1OrgCodes) {
		this.lv1OrgCodes = lv1OrgCodes;
	}
	public String[] getLv2OrgCodes() {
		return lv2OrgCodes;
	}
	public void setLv2OrgCodes(String[] lv2OrgCodes) {
		this.lv2OrgCodes = lv2OrgCodes;
	}
	public String[] getLv3OrgCodes() {
		return lv3OrgCodes;
	}
	public void setLv3OrgCodes(String[] lv3OrgCodes) {
		this.lv3OrgCodes = lv3OrgCodes;
	}
	public String[] getLv4OrgCodes() {
		return lv4OrgCodes;
	}
	public void setLv4OrgCodes(String[] lv4OrgCodes) {
		this.lv4OrgCodes = lv4OrgCodes;
	}
	public String[] getPdtLargeCodes() {
		return pdtLargeCodes;
	}
	public void setPdtLargeCodes(String[] pdtLargeCodes) {
		this.pdtLargeCodes = pdtLargeCodes;
	}
	public String[] getPdtSmallCodes() {
		return pdtSmallCodes;
	}
	public void setPdtSmallCodes(String[] pdtSmallCodes) {
		this.pdtSmallCodes = pdtSmallCodes;
	}
	public Double getBucket1() {
		return bucket1;
	}
	public void setBucket1(Double bucket1) {
		this.bucket1 = bucket1;
	}
	public Double getBucket2() {
		return bucket2;
	}
	public void setBucket2(Double bucket2) {
		this.bucket2 = bucket2;
	}
	public Double getBucket3() {
		return bucket3;
	}
	public void setBucket3(Double bucket3) {
		this.bucket3 = bucket3;
	}
	public Double getBucket4() {
		return bucket4;
	}
	public void setBucket4(Double bucket4) {
		this.bucket4 = bucket4;
	}
	public Double getBucket5() {
		return bucket5;
	}
	public void setBucket5(Double bucket5) {
		this.bucket5 = bucket5;
	}
	public Double getBucket6() {
		return bucket6;
	}
	public void setBucket6(Double bucket6) {
		this.bucket6 = bucket6;
	}
	public Double getBucket7() {
		return bucket7;
	}
	public void setBucket7(Double bucket7) {
		this.bucket7 = bucket7;
	}
	public Double getBucket8() {
		return bucket8;
	}
	public void setBucket8(Double bucket8) {
		this.bucket8 = bucket8;
	}
	public Double getBucket9() {
		return bucket9;
	}
	public void setBucket9(Double bucket9) {
		this.bucket9 = bucket9;
	}
	public Double getBucket10() {
		return bucket10;
	}
	public void setBucket10(Double bucket10) {
		this.bucket10 = bucket10;
	}
	public Double getBucket11() {
		return bucket11;
	}
	public void setBucket11(Double bucket11) {
		this.bucket11 = bucket11;
	}
	public Double getBucket12() {
		return bucket12;
	}
	public void setBucket12(Double bucket12) {
		this.bucket12 = bucket12;
	}
	public Double getBucket13() {
		return bucket13;
	}
	public void setBucket13(Double bucket13) {
		this.bucket13 = bucket13;
	}
	public Double getBucket14() {
		return bucket14;
	}
	public void setBucket14(Double bucket14) {
		this.bucket14 = bucket14;
	}
	public Double getBucket15() {
		return bucket15;
	}
	public void setBucket15(Double bucket15) {
		this.bucket15 = bucket15;
	}
	public Double getBucket16() {
		return bucket16;
	}
	public void setBucket16(Double bucket16) {
		this.bucket16 = bucket16;
	}
	public Double getBucket17() {
		return bucket17;
	}
	public void setBucket17(Double bucket17) {
		this.bucket17 = bucket17;
	}
	public Double getBucket18() {
		return bucket18;
	}
	public void setBucket18(Double bucket18) {
		this.bucket18 = bucket18;
	}
	public Double getBucket19() {
		return bucket19;
	}
	public void setBucket19(Double bucket19) {
		this.bucket19 = bucket19;
	}
	public Double getBucket20() {
		return bucket20;
	}
	public void setBucket20(Double bucket20) {
		this.bucket20 = bucket20;
	}
	public Double getBucket21() {
		return bucket21;
	}
	public void setBucket21(Double bucket21) {
		this.bucket21 = bucket21;
	}
	public Double getBucket22() {
		return bucket22;
	}
	public void setBucket22(Double bucket22) {
		this.bucket22 = bucket22;
	}
	public Double getBucket23() {
		return bucket23;
	}
	public void setBucket23(Double bucket23) {
		this.bucket23 = bucket23;
	}
	public Double getBucket24() {
		return bucket24;
	}
	public void setBucket24(Double bucket24) {
		this.bucket24 = bucket24;
	}
	public Double getBucket25() {
		return bucket25;
	}
	public void setBucket25(Double bucket25) {
		this.bucket25 = bucket25;
	}
	public Double getBucket26() {
		return bucket26;
	}
	public void setBucket26(Double bucket26) {
		this.bucket26 = bucket26;
	}
	public Double getBucket27() {
		return bucket27;
	}
	public void setBucket27(Double bucket27) {
		this.bucket27 = bucket27;
	}
	public Double getBucket28() {
		return bucket28;
	}
	public void setBucket28(Double bucket28) {
		this.bucket28 = bucket28;
	}
	public Double getBucket29() {
		return bucket29;
	}
	public void setBucket29(Double bucket29) {
		this.bucket29 = bucket29;
	}
	public Double getBucket30() {
		return bucket30;
	}
	public void setBucket30(Double bucket30) {
		this.bucket30 = bucket30;
	}
	
}
