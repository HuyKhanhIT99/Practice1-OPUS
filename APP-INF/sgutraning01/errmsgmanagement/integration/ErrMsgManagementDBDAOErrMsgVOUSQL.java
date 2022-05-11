/*=========================================================
*Copyright(c) 2022 CyberLogitec
*@FileName : ErrMsgManagementDBDAOErrMsgVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2022.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2022.05.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author HUY
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ErrMsgManagementDBDAOErrMsgVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ErrMsgManagementDBDAOErrMsgVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.clv.sgutraning01.errmsgmanagement.integration").append("\n"); 
		query.append("FileName : ErrMsgManagementDBDAOErrMsgVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("UPDATE com_err_msg    SET                                                " ).append("\n"); 
		query.append("    err_tp_cd           = @[err_tp_cd],   " ).append("\n"); 
		query.append("	err_lvl_cd          = @[err_lvl_cd],                                         " ).append("\n"); 
		query.append("    err_msg             = @[err_msg],                                            " ).append("\n"); 
		query.append("    err_desc            = @[err_desc],                                            " ).append("\n"); 
		query.append("    upd_usr_id          = @[upd_usr_id],                                            " ).append("\n"); 
		query.append("    upd_dt              = sysdate                                      " ).append("\n"); 
		query.append(" WHERE err_msg_cd = @[err_msg_cd]                                                  " ).append("\n"); 
		query.append(" AND   lang_tp_cd = 'ENG'" ).append("\n"); 

	}
}