package com.inspur.incloud.common.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "swagger.service")
public class SwaggerProperties {
//	swagger:
//		  service:
//		    version: "1.0"
//		    title: ${spring.application.name}
//		    description: "A service that provides ..."
//		    termsPath: ""
//		    email: "your@email.com"
//		    licenceType: ""
//		    licencePath: ""
//		    enable: true
	
    private String version = "1.0";
    private String title = "inspur cloud rest api doc";
    private String description = "inspur cloud rest api doc";
    private String termsPath;  
    private String email = "";
    private String licenceType = "";
    private String licencePath = "";
    private boolean enable = true;

    public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsPath() {
        return termsPath;
    }

    public void setTermsPath(String termsPath) {
        this.termsPath = termsPath;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public String getLicencePath() {
        return licencePath;
    }

    public void setLicencePath(String licencePath) {
        this.licencePath = licencePath;
    }
}