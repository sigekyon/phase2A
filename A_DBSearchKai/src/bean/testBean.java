package bean;

import java.io.Serializable;

public class testBean implements Serializable {
    private static final long serialVersionUID = 1L;

    String registrant_id = null;
    String registrant_password = null;
	public String getRegistrant_id() {
		return registrant_id;
	}
	public void setRegistrant_id(String registrant_id) {
		this.registrant_id = registrant_id;
	}
	public String getRegistrant_password() {
		return registrant_password;
	}
	public void setRegistrant_password(String registrant_password) {
		this.registrant_password = registrant_password;
	}
}
