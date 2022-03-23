package com.kea;

public class Rateinfo {
    public String code;
    public String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String rate;

    /**
     * @param Code Kode der anvendes for denne valuta
     * @param Desc Beskrivelse til valuta
     * @param Rate Antal danske kr for 100 af den valuta vi omregner til
     */
    public Rateinfo(String Code, String Desc, String Rate) {
        code=Code;
        desc=Desc;
        rate=Rate;
    }
    @Override
    public String toString(){
        return "Rateinfo - " + " Code = " + code + " Desc = " + desc + " Rate = " + rate;
    }
}
