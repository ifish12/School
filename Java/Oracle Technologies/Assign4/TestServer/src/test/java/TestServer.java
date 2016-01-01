import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by ian on 15-10-02.
 */
public class TestServer {

    public static final String SERVER = "localhost";
    public static final int PORT = 9999;
    public static final String PREFIX = "http://" + SERVER + ":" + String.valueOf(PORT);


    /* private helper for makeHttp*Request() */
    private static void copyStreamBuffered(InputStream in, OutputStream out) throws IOException {
        BufferedInputStream inBuf = new BufferedInputStream(in, 1024);
        BufferedOutputStream outBuf = new BufferedOutputStream(out, 1024);
        int i;
        while((i = inBuf.read()) > 0)
            outBuf.write(i);
        outBuf.flush();
    }

    /**
     * Make an HTTP Request
     * @param urlStr URL for request
     * @param method HTTP method
     * @return An HttpResponse with status, headers and response body (if given).
     * @throws IOException
     */
    private static HttpResponse makeHttpJsonRequest(String urlStr, String method) throws IOException {
        return makeHttpJsonRequest(urlStr, method, null);
    }


    /**
     * Make an HTTP Request with JSON body
     * @param urlStr URL for request
     * @param method HTTP method
     * @param requestJson The JSON resquest body
     * @return An HttpResponse with status, headers and response body (if given).
     * @throws IOException
     */
    private static HttpResponse makeHttpJsonRequest(String urlStr, String method, String requestJson) throws IOException {

        // Create URL object for HTTP connection
        URL url = new URL(urlStr);

        // Create HTTP connection from URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);

        // If the user has specified JSON for the request, configure connection, add content-type header
        // and copy JSON to output stream
        if(requestJson != null) {
            con.setDoOutput(true);
            con.setRequestProperty("content-type", "application/json");
            copyStreamBuffered(new ByteArrayInputStream(requestJson.getBytes()), con.getOutputStream());
        }

        // Retrieve information connection
        Map<String, List<String>> headers = con.getHeaderFields();
        int status = con.getResponseCode();
        String response = null;
        try {
            // copy JSON from output stream
            ByteArrayOutputStream responseBytes = new ByteArrayOutputStream();
            copyStreamBuffered(con.getInputStream(), responseBytes);
            response = new String(responseBytes.toByteArray());
        }
        catch(IOException e) { /* no response body */ }

        return new HttpResponse(status, headers, response);
    }

    // Sample user created during setUp
    private User sampleUser;

    private Defect sampleDefect;

    /**
     * Create a sampleUser user and defect.
     * @throws IOException
     */
    @Before
    public void setUp() throws IOException {
        // Create sample user.
        sampleUser = new User().setName("Bar")
                               .setImageUrl("http://example.com/bar")
                               .setUserType(UserType.DEVELOPER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", sampleUser.toJson());
        sampleUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user
       // System.out.println(response.getStatus());
        // Create sample defect.
        sampleDefect = new Defect().setSummary("Unfortunately, Notes has Stopped...")
                                   .setCreated(new Date())
                                   .setCreatedByUrl(sampleUser.getUrl())
                                   .setSeverity(Severity.TRIVIAL)
                                   .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", sampleDefect.toJson());
        //System.out.println(response.getHeaders().get("Location").get(0));
        sampleDefect.setUrl(response.getHeaders().get("Location").get(0));
    }

    /**
     * Remove all users and defects from the server: restore server to initial state
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {

        String[] repos = new String[] {"defect", "user"}; // The order matters due to FK constraints

        for(String repo : repos) {
            // Get all items from repo
            HttpResponse response = makeHttpJsonRequest(PREFIX + "/" + repo, "GET");
            if (response.getStatus() != 200)
                throw new IOException("Cannot get /" + repo + " repository. Something is wrong, please restart server.");

            // extract the JSON array from inside the response JSON, it it's not there the repo is empty
            JSONArray items = null;
            try {
                JSONObject root = new JSONObject(new JSONTokener(response.getBody()));
                items = root.getJSONObject("_embedded").getJSONArray(repo);
            } catch (JSONException e) { /* empty repo, or else no item array */ }

            // For non-empty repos, delete all items
            if (items != null) {
                for (int i = 0; i < items.length(); i++) {
                    // the URL is located in the "self" -> "href" field.
                    String href = items.getJSONObject(i).getJSONObject("_links").getJSONObject("self").getString("href");

                    // Delete the item
                    HttpResponse deleteResponse = makeHttpJsonRequest(href, "DELETE");
                    if (deleteResponse.getStatus() != 204)
                        throw new Exception("Could not delete " + href + ". Please restart server.");
                }
            }
        }
    }


    @Test
    public void testUserToJson() {
        // TODO: optional
        assertEquals("{\"name\" : \"Bar\", \"imageUrl\" : \"http://example.com/bar\", \"userType\" : \"DEVELOPER\"}", sampleUser.toJson());


    }

    @Test
    public void testUserFromJson() {
        // TODO: optional
        User testFromJ = new User();
        JSONObject json = new JSONObject("{\"name\": \"Vi\", \"imageUrl\": \"http://test.org\", \"userType\": \"DEVELOPER\", \"_links\" : {" +
                "\"self\" : {" +
                "\"href\" : \"http://localhost:9999/user/1\"" +
                "}," +
                "\"assigned\" : {" +
                "\"href\" : \"http://localhost:9999/user/1/assigned\"" +
                "}," +
                "\"created\" : {" +
                "\"href\" : \"http://localhost:9999/user/1/created\"" +
                "}" +
                "}" +
                "}");

        testFromJ.setUserType(UserType.DEVELOPER);
        testFromJ.setName("Vi");
        testFromJ.setImageUrl("http://test.org");
        testFromJ.setUrl("http://localhost:9999/user/1");
        assertEquals(testFromJ, new User().fromJson(json));


    }

    @Test
    public void testDefectToJson() {
        // TODO: optional
        String createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        assertEquals("{\"created\" : \"" + createdDate + "\""+ ", \"summary\" : \"Unfortunately, Notes has Stopped...\", \"status\" : \"CREATED\", \"severity\" : \"TRIVIAL\", \"createdBy\" : \"" + sampleUser.getUrl() +"\"}", sampleDefect.toJson());

    }

    @Test
    public void testDefectFromJson() {
        // TODO: optional
    }

    /**
     * Test Requirement 0: can connect to server.
     * @throws IOException
     */
    @Test
    public void testConnection() throws IOException {
        HttpResponse response = makeHttpJsonRequest(PREFIX, "GET");
        assertEquals(200, response.getStatus());

    }

    /**
     * Test Requirement 2 (R): read user
     * @throws IOException
     */
    @Test
    public void testReadUser() throws IOException {
        HttpResponse response = makeHttpJsonRequest(sampleUser.getUrl(), "GET");
        User receivedUser = User.fromJson(new JSONObject(new JSONTokener(response.getBody())));
        assertEquals("Bar", receivedUser.getName());
        assertEquals("http://example.com/bar", receivedUser.getImageUrl());
        assertEquals(UserType.DEVELOPER, receivedUser.getUserType());
    }

    @Test
    public void testUniqueUsername() throws IOException {
        User duplicateUser = new User();
        duplicateUser.setName("Bar")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        assertEquals(409, response.getStatus());
    }

    @Test
    public void testProperUserType() throws IOException {
        User duplicateUser = new User();
        duplicateUser.setName("Bad")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.TESTER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        assertEquals(400, response.getStatus());

        duplicateUser = new User();
        duplicateUser.setName("Bad1")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        assertEquals(201, response.getStatus());

        duplicateUser = new User();
        duplicateUser.setName("Bad2")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.CUSTOMER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        assertEquals(201, response.getStatus());
        duplicateUser = new User();
        duplicateUser.setName("Bad3")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.MANAGER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testAssignedAcceptedDefect() throws IOException {
        Defect badDefect = new Defect();

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.ACCEPTED);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(500, response.getStatus());


        User devUser = new User();

        devUser.setName("devTest")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", devUser.toJson());
        devUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.ACCEPTED)
                .setAssignedToUrl(devUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

    }

    @Test
    public void testAssignedReopenedDefect() throws IOException {
        Defect badDefect = new Defect();

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.REOPENED);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(500, response.getStatus());


        User devUser = new User();

        devUser.setName("devTest")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", devUser.toJson());
        devUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.REOPENED)
                .setAssignedToUrl(devUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

    }

    @Test
    public void testAssignedDefectToDeveloper() throws IOException {
        User newUser = new User();
        Defect badDefect = new Defect();

        newUser.setName("devTest")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", newUser.toJson());
        newUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.ACCEPTED)
                .setAssignedToUrl(newUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus()); // TEST: Assigned to developer


        User managerUser   = new User();
        User duplicateUser = new User();

        duplicateUser.setName("Bad2")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.CUSTOMER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());

        managerUser.setName("userTest")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.MANAGER);
        response = makeHttpJsonRequest(PREFIX + "/user/", "POST", managerUser.toJson());
        managerUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.ACCEPTED)
                .setAssignedToUrl(managerUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(400, response.getStatus()); // Not implemented (TEST: Assign defect to non-dev. Expected failure. )
    }

    @Test
    public void testDefectStatus() throws IOException {
        // Test: Accepted

        User newUser = new User();
        Defect badDefect = new Defect();

        newUser.setName("devTest")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", newUser.toJson());
        newUser.setUrl(response.getHeaders().get("Location").get(0)); // Header from POST contains the URL of the new user

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.ACCEPTED)
                .setAssignedToUrl(newUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

        // Test: Reopened

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.REOPENED)
                .setAssignedToUrl(newUser.getUrl());
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

        // Test: Closed

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.CLOSED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());


        // Test: Created

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

        // Test: Fixed

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.FIXED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
        assertEquals(201, response.getStatus());

    }

    @Test
    public void testDefectDate() throws IOException {
        Defect badDefect = new Defect();
        Date today = new Date();
        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setModified(new Date(today.getTime() + (1000 * 60 * 60 * 24)))
                        .setCreatedByUrl(sampleUser.getUrl())
                        .setSeverity(Severity.TRIVIAL)
                        .setStatus(Status.CREATED);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(201, response.getStatus());


        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date(today.getTime() + (1000 * 60 * 60 * 24)))
                .setModified(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(500, response.getStatus());

    }

    @Test
    public void testDefectSeverity() throws IOException{
        Defect badDefect = new Defect();
        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.TRIVIAL)
                .setStatus(Status.CREATED);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(201, response.getStatus());

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.MAJOR)
                .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(201, response.getStatus());

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.MINOR)
                .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(201, response.getStatus());

        badDefect.setSummary("Unfortunately, Notes has Stopped...")
                .setCreated(new Date())
                .setCreatedByUrl(sampleUser.getUrl())
                .setSeverity(Severity.SHOWSTOPPER)
                .setStatus(Status.CREATED);
        response = makeHttpJsonRequest(PREFIX + "/defect/", "POST", badDefect.toJson());
//        System.out.println(badDefect.getModified());
//        System.out.println(badDefect.getCreated());
        assertEquals(201, response.getStatus());
    }

    @Test
    public void testGetUserDefect() throws IOException, ParseException {
        HttpResponse response = makeHttpJsonRequest(sampleUser.getUrl() + "/created", "GET");
        JSONObject root = new JSONObject(new JSONTokener(response.getBody()));
        List<Defect> defect = Defect.fromJson(root.getJSONObject("_embedded").getJSONArray("defect"));
        assertEquals(1, defect.size());
    }

    @Test
    public void testUserCRUD() throws IOException {
        // TEST: Create User

        User duplicateUser = new User();
        duplicateUser.setName("Bad")
                .setImageUrl("http://example.com/bar")
                .setUserType(UserType.DEVELOPER);
        HttpResponse response = makeHttpJsonRequest(PREFIX + "/user/", "POST", duplicateUser.toJson());
        duplicateUser.setUrl(response.getHeaders().get("Location").get(0));
        assertEquals(201, response.getStatus());

        // TEST: Update User

        duplicateUser.setName("Bad 2");
        System.out.println(duplicateUser.getUrl());
        response = makeHttpJsonRequest(duplicateUser.getUrl(), "PUT", duplicateUser.toJson());
        assertEquals(204, response.getStatus());

        // TEST: Read All Users

        response = makeHttpJsonRequest(PREFIX + "/user/", "GET");
        JSONObject root = new JSONObject(new JSONTokener(response.getBody()));
        List<User> user = User.fromJson(root.getJSONObject("_embedded").getJSONArray("user"));
        assertEquals(2, user.size());

        // TEST: Read User

        response = makeHttpJsonRequest(sampleUser.getUrl(), "GET");
        assertEquals(200, response.getStatus());

        // TEST: Delete User

        response = makeHttpJsonRequest(sampleUser.getUrl(), "DELETE");
       // System.out.println(sampleUser.getUrl());
        assertEquals(409, response.getStatus()); // because of FK constraints between Defect and User

        response = makeHttpJsonRequest(duplicateUser.getUrl(), "DELETE");
       // System.out.println(duplicateUser.getUrl());
        assertEquals(204, response.getStatus());








    }



    // TODO the rest of the test cases
}
