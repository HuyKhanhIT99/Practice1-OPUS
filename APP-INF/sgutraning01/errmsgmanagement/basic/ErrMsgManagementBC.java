/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : ErrMsgManagementBC.java
*@FileTitle : Error Message Management
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.basic;

import java.util.List;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.vo.ErrMsgVO;

/**
 * ALPS-Sgutraning01 Business Logic Command Interface<br>
 * - ALPS-Sgutraning01에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HUY
 * @since J2EE 1.6
 */

public interface ErrMsgManagementBC {

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ErrMsgVO	errMsgVO
	 * @return List<ErrMsgVO>
	 * @exception EventException
	 */
	public List<ErrMsgVO> SErrMsgVO(ErrMsgVO errMsgVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param ErrMsgVO[] errMsgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void MErrMsgVO(ErrMsgVO[] errMsgVO,SignOnUserAccount account) throws EventException;
	
	public boolean validateErrMsgVO(ErrMsgVO errMsgVO) throws EventException;
}