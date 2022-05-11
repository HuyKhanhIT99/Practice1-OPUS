  function SGU_TRN_0001() {
    	this.processButtonClick		= tprocessButtonClick;
    	this.setSheetObject 		= setSheetObject;
    	this.loadPage 				= loadPage;
    	this.initSheet 				= initSheet;
    	this.initControl            = initControl;
    	this.doActionIBSheet 		= doActionIBSheet;
    	this.setTabObject 			= setTabObject;
    	this.validateForm 			= validateForm;
    }
	var sheetObjects=new Array();
	var sheetCnt=0
	var rowcount=0;
	document.onclick=processButtonClick;
	function processButtonClick() {
		/** *** setting sheet object **** */
		var sheetObject1 = sheetObjects[0];
		/** **************************************************** */
		var formObj = document.form;
		try {
			var srcName = ComGetEvent("name");			
			switch (srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObj, IBSEARCH);
					break;
				case "btn_Add":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				}
				
		} catch (e) {
			if (e == "[object Error]") {
				ComShowCodeMessage('JOO00001');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
 	function loadPage() {
		for (i = 0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		//auto search data after loading finish.
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
   	}	

	function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	
	 function doActionIBSheet(sheetObj,formObj,sAction) {
	        switch(sAction) {
				case IBSEARCH:      //조회
	                //조회처리
					formObj.f_cmd.value=SEARCH;
	 				sheetObj.DoSearch("SGU_TRN_0001GS.do", FormQueryString(formObj) );
					break;
				case IBSAVE:
	            	formObj.f_cmd.value=MULTI;
	                sheetObj.DoSave("SGU_TRN_0001GS.do", FormQueryString(formObj));
					break;
				case IBINSERT:      // 입력
//					sheetObj.SelectCell(sheetObj.GetSelectRow(), 0); // 0 mode k cho chỉnh sữa
//					sheetObj.DataInsert();
					sheetObj.DataInsert(sheetObj.GetSelectRow());
					break;
				case IBDOWNEXCEL:	//엑셀다운로드
					
	        }
	    }
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
            	with(sheetObj){
                var HeadTitle="|Del|Msg Cd|Msg Type|Msg level|Message|Description" ;
                var headCount=ComCountHeadTitle(HeadTitle);

                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"DelCheck",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"DEL",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"err_msg_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"err_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"Server|UI|Both", ComboCode:"S|U|B" },
	                     {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"err_lvl_cd",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, ComboText:"ERR|WARNING|INFO", ComboCode:"E|W|I" },
	                     {Type:"Text",      Hidden:0, Width:400,  Align:"Left",    ColMerge:0,   SaveName:"err_msg",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:1 },
	                     {Type:"Text",      Hidden:0, Width:250,  Align:"Left",    ColMerge:0,   SaveName:"err_desc",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
                InitColumns(cols);
                SetWaitImageVisible(0);
                resizeSheet();
                }
            break;
        }
    }
    
    function resizeSheet(){
   	         ComResizeSheet(sheetObjects[0]);
   }
    function sheet1_OnChange(row, col, sheetObj) {
    	 if(col == 2){
     	    console.log(row);
     	 }
    }
  
    function sheet1_OnBeforeSave() {
    	
   }
    function validateForm(sheetObj,formObj,sAction){

    }