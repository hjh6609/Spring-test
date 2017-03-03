package board;

public class VO {
	
		private int num;
		private String txtName;
		private String txtPwd;
		private String txtTitle;
		private String txtCon;
		private String time;
		private int hit;
		private int ref;
		private int indent;
		private int step;
		private boolean dayNew;
		
		public VO() {
			
		}
		
		public VO(int num, String txtName, String txtPwd, String txtTitle,
				String txtCon, String time, int hit, int ref, int indent, int step, boolean dayNew) {
			
		this.num = num;
		this.txtName = txtName;
		this.txtPwd = txtPwd;
		this.txtTitle = txtTitle;
		this.txtCon = txtCon;
		this.time = time;
		this.hit = hit;
		this.ref = ref;
		this.indent = indent;
		this.step = step;
		this.dayNew = dayNew;
	}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getTxtName() {
			System.out.println(  "Vo name    " +txtPwd);
			return txtName;
		}

		public void setTxtName(String txtName) {
			this.txtName = txtName;
		}

		public String getPwd() {
			System.out.println(  "get    " +txtPwd);
			return txtPwd;
		}

		public void setPwd(String txtPwd) {
			this.txtPwd = txtPwd;
		}

		public String getTxtTitle() {
			return txtTitle;
		}

		public void setTxtTitle(String txtTitle) {
			this.txtTitle = txtTitle;
		}

		public String getTxtCon() {
			return txtCon;
		}

		public void setTxtCon(String txtCon) {
			this.txtCon = txtCon;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public int getHit() {
			return hit;
		}

		public void setHit(int hit) {
			this.hit = hit;
		}

		public int getRef() {
			return ref;
		}

		public void setRef(int ref) {
			this.ref = ref;
		}

		public int getIndent() {
			return indent;
		}

		public void setIndent(int indent) {
			this.indent = indent;
		}

		public int getStep() {
			return step;
		}

		public void setStep(int step) {
			this.step = step;
		}

		public boolean isDayNew() {
			return dayNew;
		}

		public void setDayNew(boolean dayNew) {
			this.dayNew = dayNew;
		}

		
}
