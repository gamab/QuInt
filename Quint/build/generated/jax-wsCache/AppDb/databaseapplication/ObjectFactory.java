
package databaseapplication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the databaseapplication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddNewUser_QNAME = new QName("http://databaseApplication/", "addNewUser");
    private final static QName _AddNewUserResponse_QNAME = new QName("http://databaseApplication/", "addNewUserResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://databaseApplication/", "deleteUser");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://databaseApplication/", "deleteUserResponse");
    private final static QName _EditUserProfile_QNAME = new QName("http://databaseApplication/", "editUserProfile");
    private final static QName _EditUserProfileResponse_QNAME = new QName("http://databaseApplication/", "editUserProfileResponse");
    private final static QName _EmailAlreadyUsed_QNAME = new QName("http://databaseApplication/", "emailAlreadyUsed");
    private final static QName _EmailAlreadyUsedResponse_QNAME = new QName("http://databaseApplication/", "emailAlreadyUsedResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://databaseApplication/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://databaseApplication/", "getAllStudentsResponse");
    private final static QName _GetNumberOfUsers_QNAME = new QName("http://databaseApplication/", "getNumberOfUsers");
    private final static QName _GetNumberOfUsersResponse_QNAME = new QName("http://databaseApplication/", "getNumberOfUsersResponse");
    private final static QName _GetPassword_QNAME = new QName("http://databaseApplication/", "getPassword");
    private final static QName _GetPasswordResponse_QNAME = new QName("http://databaseApplication/", "getPasswordResponse");
    private final static QName _Hello_QNAME = new QName("http://databaseApplication/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://databaseApplication/", "helloResponse");
    private final static QName _IsUSerAdmin_QNAME = new QName("http://databaseApplication/", "isUSerAdmin");
    private final static QName _IsUSerAdminResponse_QNAME = new QName("http://databaseApplication/", "isUSerAdminResponse");
    private final static QName _IsUserInDB_QNAME = new QName("http://databaseApplication/", "isUserInDB");
    private final static QName _IsUserInDBResponse_QNAME = new QName("http://databaseApplication/", "isUserInDBResponse");
    private final static QName _ListData_QNAME = new QName("http://databaseApplication/", "listData");
    private final static QName _ListDataResponse_QNAME = new QName("http://databaseApplication/", "listDataResponse");
    private final static QName _QueryInfo_QNAME = new QName("http://databaseApplication/", "queryInfo");
    private final static QName _QueryInfoResponse_QNAME = new QName("http://databaseApplication/", "queryInfoResponse");
    private final static QName _SearchStudent_QNAME = new QName("http://databaseApplication/", "searchStudent");
    private final static QName _SearchStudentResponse_QNAME = new QName("http://databaseApplication/", "searchStudentResponse");
    private final static QName _SetAdminRight_QNAME = new QName("http://databaseApplication/", "setAdminRight");
    private final static QName _SetAdminRightResponse_QNAME = new QName("http://databaseApplication/", "setAdminRightResponse");
    private final static QName _SetPassword_QNAME = new QName("http://databaseApplication/", "setPassword");
    private final static QName _SetPasswordResponse_QNAME = new QName("http://databaseApplication/", "setPasswordResponse");
    private final static QName _UserPasswordMatch_QNAME = new QName("http://databaseApplication/", "userPasswordMatch");
    private final static QName _UserPasswordMatchResponse_QNAME = new QName("http://databaseApplication/", "userPasswordMatchResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: databaseapplication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddNewUser }
     * 
     */
    public AddNewUser createAddNewUser() {
        return new AddNewUser();
    }

    /**
     * Create an instance of {@link AddNewUserResponse }
     * 
     */
    public AddNewUserResponse createAddNewUserResponse() {
        return new AddNewUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link EditUserProfile }
     * 
     */
    public EditUserProfile createEditUserProfile() {
        return new EditUserProfile();
    }

    /**
     * Create an instance of {@link EditUserProfileResponse }
     * 
     */
    public EditUserProfileResponse createEditUserProfileResponse() {
        return new EditUserProfileResponse();
    }

    /**
     * Create an instance of {@link EmailAlreadyUsed }
     * 
     */
    public EmailAlreadyUsed createEmailAlreadyUsed() {
        return new EmailAlreadyUsed();
    }

    /**
     * Create an instance of {@link EmailAlreadyUsedResponse }
     * 
     */
    public EmailAlreadyUsedResponse createEmailAlreadyUsedResponse() {
        return new EmailAlreadyUsedResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetNumberOfUsers }
     * 
     */
    public GetNumberOfUsers createGetNumberOfUsers() {
        return new GetNumberOfUsers();
    }

    /**
     * Create an instance of {@link GetNumberOfUsersResponse }
     * 
     */
    public GetNumberOfUsersResponse createGetNumberOfUsersResponse() {
        return new GetNumberOfUsersResponse();
    }

    /**
     * Create an instance of {@link GetPassword }
     * 
     */
    public GetPassword createGetPassword() {
        return new GetPassword();
    }

    /**
     * Create an instance of {@link GetPasswordResponse }
     * 
     */
    public GetPasswordResponse createGetPasswordResponse() {
        return new GetPasswordResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link IsUSerAdmin }
     * 
     */
    public IsUSerAdmin createIsUSerAdmin() {
        return new IsUSerAdmin();
    }

    /**
     * Create an instance of {@link IsUSerAdminResponse }
     * 
     */
    public IsUSerAdminResponse createIsUSerAdminResponse() {
        return new IsUSerAdminResponse();
    }

    /**
     * Create an instance of {@link IsUserInDB }
     * 
     */
    public IsUserInDB createIsUserInDB() {
        return new IsUserInDB();
    }

    /**
     * Create an instance of {@link IsUserInDBResponse }
     * 
     */
    public IsUserInDBResponse createIsUserInDBResponse() {
        return new IsUserInDBResponse();
    }

    /**
     * Create an instance of {@link ListData }
     * 
     */
    public ListData createListData() {
        return new ListData();
    }

    /**
     * Create an instance of {@link ListDataResponse }
     * 
     */
    public ListDataResponse createListDataResponse() {
        return new ListDataResponse();
    }

    /**
     * Create an instance of {@link QueryInfo }
     * 
     */
    public QueryInfo createQueryInfo() {
        return new QueryInfo();
    }

    /**
     * Create an instance of {@link QueryInfoResponse }
     * 
     */
    public QueryInfoResponse createQueryInfoResponse() {
        return new QueryInfoResponse();
    }

    /**
     * Create an instance of {@link SearchStudent }
     * 
     */
    public SearchStudent createSearchStudent() {
        return new SearchStudent();
    }

    /**
     * Create an instance of {@link SearchStudentResponse }
     * 
     */
    public SearchStudentResponse createSearchStudentResponse() {
        return new SearchStudentResponse();
    }

    /**
     * Create an instance of {@link SetAdminRight }
     * 
     */
    public SetAdminRight createSetAdminRight() {
        return new SetAdminRight();
    }

    /**
     * Create an instance of {@link SetAdminRightResponse }
     * 
     */
    public SetAdminRightResponse createSetAdminRightResponse() {
        return new SetAdminRightResponse();
    }

    /**
     * Create an instance of {@link SetPassword }
     * 
     */
    public SetPassword createSetPassword() {
        return new SetPassword();
    }

    /**
     * Create an instance of {@link SetPasswordResponse }
     * 
     */
    public SetPasswordResponse createSetPasswordResponse() {
        return new SetPasswordResponse();
    }

    /**
     * Create an instance of {@link UserPasswordMatch }
     * 
     */
    public UserPasswordMatch createUserPasswordMatch() {
        return new UserPasswordMatch();
    }

    /**
     * Create an instance of {@link UserPasswordMatchResponse }
     * 
     */
    public UserPasswordMatchResponse createUserPasswordMatchResponse() {
        return new UserPasswordMatchResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "addNewUser")
    public JAXBElement<AddNewUser> createAddNewUser(AddNewUser value) {
        return new JAXBElement<AddNewUser>(_AddNewUser_QNAME, AddNewUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNewUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "addNewUserResponse")
    public JAXBElement<AddNewUserResponse> createAddNewUserResponse(AddNewUserResponse value) {
        return new JAXBElement<AddNewUserResponse>(_AddNewUserResponse_QNAME, AddNewUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "editUserProfile")
    public JAXBElement<EditUserProfile> createEditUserProfile(EditUserProfile value) {
        return new JAXBElement<EditUserProfile>(_EditUserProfile_QNAME, EditUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditUserProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "editUserProfileResponse")
    public JAXBElement<EditUserProfileResponse> createEditUserProfileResponse(EditUserProfileResponse value) {
        return new JAXBElement<EditUserProfileResponse>(_EditUserProfileResponse_QNAME, EditUserProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailAlreadyUsed }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "emailAlreadyUsed")
    public JAXBElement<EmailAlreadyUsed> createEmailAlreadyUsed(EmailAlreadyUsed value) {
        return new JAXBElement<EmailAlreadyUsed>(_EmailAlreadyUsed_QNAME, EmailAlreadyUsed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmailAlreadyUsedResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "emailAlreadyUsedResponse")
    public JAXBElement<EmailAlreadyUsedResponse> createEmailAlreadyUsedResponse(EmailAlreadyUsedResponse value) {
        return new JAXBElement<EmailAlreadyUsedResponse>(_EmailAlreadyUsedResponse_QNAME, EmailAlreadyUsedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getNumberOfUsers")
    public JAXBElement<GetNumberOfUsers> createGetNumberOfUsers(GetNumberOfUsers value) {
        return new JAXBElement<GetNumberOfUsers>(_GetNumberOfUsers_QNAME, GetNumberOfUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberOfUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getNumberOfUsersResponse")
    public JAXBElement<GetNumberOfUsersResponse> createGetNumberOfUsersResponse(GetNumberOfUsersResponse value) {
        return new JAXBElement<GetNumberOfUsersResponse>(_GetNumberOfUsersResponse_QNAME, GetNumberOfUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getPassword")
    public JAXBElement<GetPassword> createGetPassword(GetPassword value) {
        return new JAXBElement<GetPassword>(_GetPassword_QNAME, GetPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "getPasswordResponse")
    public JAXBElement<GetPasswordResponse> createGetPasswordResponse(GetPasswordResponse value) {
        return new JAXBElement<GetPasswordResponse>(_GetPasswordResponse_QNAME, GetPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUSerAdmin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "isUSerAdmin")
    public JAXBElement<IsUSerAdmin> createIsUSerAdmin(IsUSerAdmin value) {
        return new JAXBElement<IsUSerAdmin>(_IsUSerAdmin_QNAME, IsUSerAdmin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUSerAdminResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "isUSerAdminResponse")
    public JAXBElement<IsUSerAdminResponse> createIsUSerAdminResponse(IsUSerAdminResponse value) {
        return new JAXBElement<IsUSerAdminResponse>(_IsUSerAdminResponse_QNAME, IsUSerAdminResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserInDB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "isUserInDB")
    public JAXBElement<IsUserInDB> createIsUserInDB(IsUserInDB value) {
        return new JAXBElement<IsUserInDB>(_IsUserInDB_QNAME, IsUserInDB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsUserInDBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "isUserInDBResponse")
    public JAXBElement<IsUserInDBResponse> createIsUserInDBResponse(IsUserInDBResponse value) {
        return new JAXBElement<IsUserInDBResponse>(_IsUserInDBResponse_QNAME, IsUserInDBResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "listData")
    public JAXBElement<ListData> createListData(ListData value) {
        return new JAXBElement<ListData>(_ListData_QNAME, ListData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "listDataResponse")
    public JAXBElement<ListDataResponse> createListDataResponse(ListDataResponse value) {
        return new JAXBElement<ListDataResponse>(_ListDataResponse_QNAME, ListDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "queryInfo")
    public JAXBElement<QueryInfo> createQueryInfo(QueryInfo value) {
        return new JAXBElement<QueryInfo>(_QueryInfo_QNAME, QueryInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "queryInfoResponse")
    public JAXBElement<QueryInfoResponse> createQueryInfoResponse(QueryInfoResponse value) {
        return new JAXBElement<QueryInfoResponse>(_QueryInfoResponse_QNAME, QueryInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "searchStudent")
    public JAXBElement<SearchStudent> createSearchStudent(SearchStudent value) {
        return new JAXBElement<SearchStudent>(_SearchStudent_QNAME, SearchStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "searchStudentResponse")
    public JAXBElement<SearchStudentResponse> createSearchStudentResponse(SearchStudentResponse value) {
        return new JAXBElement<SearchStudentResponse>(_SearchStudentResponse_QNAME, SearchStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAdminRight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "setAdminRight")
    public JAXBElement<SetAdminRight> createSetAdminRight(SetAdminRight value) {
        return new JAXBElement<SetAdminRight>(_SetAdminRight_QNAME, SetAdminRight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAdminRightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "setAdminRightResponse")
    public JAXBElement<SetAdminRightResponse> createSetAdminRightResponse(SetAdminRightResponse value) {
        return new JAXBElement<SetAdminRightResponse>(_SetAdminRightResponse_QNAME, SetAdminRightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "setPassword")
    public JAXBElement<SetPassword> createSetPassword(SetPassword value) {
        return new JAXBElement<SetPassword>(_SetPassword_QNAME, SetPassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "setPasswordResponse")
    public JAXBElement<SetPasswordResponse> createSetPasswordResponse(SetPasswordResponse value) {
        return new JAXBElement<SetPasswordResponse>(_SetPasswordResponse_QNAME, SetPasswordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserPasswordMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "userPasswordMatch")
    public JAXBElement<UserPasswordMatch> createUserPasswordMatch(UserPasswordMatch value) {
        return new JAXBElement<UserPasswordMatch>(_UserPasswordMatch_QNAME, UserPasswordMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserPasswordMatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://databaseApplication/", name = "userPasswordMatchResponse")
    public JAXBElement<UserPasswordMatchResponse> createUserPasswordMatchResponse(UserPasswordMatchResponse value) {
        return new JAXBElement<UserPasswordMatchResponse>(_UserPasswordMatchResponse_QNAME, UserPasswordMatchResponse.class, null, value);
    }

}
