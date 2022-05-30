package gulewskr.rentcarapp.data.domain.mark;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateMark {
    private String name;
    private String logoSrc;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogoSrc() {
        return logoSrc;
    }
    public void setLogoSrc(String logoSrc) {
        this.logoSrc = logoSrc;
    }
}
