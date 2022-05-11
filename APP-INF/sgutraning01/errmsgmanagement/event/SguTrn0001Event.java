/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : SguTrn0001Event.java
*@FileTitle : Error Message Management
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.vo.ErrMsgVO;


/**
 * SGU_TRN_0001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  SGU_TRN_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author HUY
 * @see SGU_TRN_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class SguTrn0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	ErrMsgVO errMsgVO = null;
	
	/** Table Value Object Multi Data 처리 */
	ErrMsgVO[] errMsgVOs = null;
	
	String checkExistErrMSgCd ;

	public String getCheckExistErrMSgCd() {
		return checkExistErrMSgCd;
	}

	public void setCheckExistErrMSgCd(String checkExistErrMSgCd) {
		this.checkExistErrMSgCd = checkExistErrMSgCd;
	}

	public SguTrn0001Event(){}
	
	public void setErrMsgVO(ErrMsgVO errMsgVO){
		this. errMsgVO = errMsgVO;
	}

	public void setErrMsgVOS(ErrMsgVO[] errMsgVOs){
		this. errMsgVOs = errMsgVOs;
	}

	public ErrMsgVO getErrMsgVO(){
		return errMsgVO;
	}

	public ErrMsgVO[] getErrMsgVOS(){
		return errMsgVOs;
	}

}