package com.tools;

public class ChStr {
	/**
	 * ���ܣ����������������
	 * 
	 * @param str
	 * @return
	 */
	public String chStr(String str) {
		if (str == null) { 						// ������strΪnullʱ
			str = ""; 							// ������str��ֵΪ��
		} else {
			try {								// ��׽�쳣
                   //���ַ���ת��ΪUTF-8����
				str = (new String(str.getBytes("iso-8859-1"), "UTF-8")).trim();
			} catch (Exception e) {				// �����쳣
				e.printStackTrace(System.err); 	// ����쳣��Ϣ
			}
		}
		return str; 								// ����ת����ı���str
	}
}
