package sample.dataHandle;

/**
 * Created by Ramesh on 4/22/2017.
 */
public class data {
    protected String id;
    protected String name;
    protected String  address;
    protected String city;
    protected String country;
    protected String postcode;
    protected String telephone;
    protected String fax;
    protected String email;
    protected String contact;

    public data()
    {

    }
    public data(String id,String name,String add,String city,String con,String pc,String tel,String fax,String email,String contact)
    {
        this.id=id;
        this.name=name;
        this.address=add;
        this.city=city;
        this.country=con;
        this.postcode=pc;
        this.telephone=tel;
        this.fax=fax;
        this.email=email;
        this.contact=contact;
    }
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public String getCity()
    {
        return city;
    }
    public String getCountry()
    {
        return country;
    }
    public String getPostcode()
    {
        return postcode;
    }
    public String getTelephone()
    {
        return telephone;
    }
    public String getFax()
    {
        return fax;
    }
    public String getEmail()
    {
        return email;
    }
    public String getContact()
    {
        return contact;
    }


}
