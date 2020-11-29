package main.java.models.http;

/**
 * An ENUM with all HTTP response codes
 * @author Teegan Krieger
 * @LastUpdate 10/5/2020
 */
public enum ResponseCode {
    No_Code(0), //Not a real HTTP code. Used when an exception occurs and no code is returned
    Connection_Error(1), //Not a real HTTP code. Used when a network error occurs
    Continue(100),
    Switching_Protocol(101),
    Processing(102),
    Early_Hints(103),
    OK(200),
    Created(201),
    Accepted(202),
    Non_Authoritative_Information(203),
    No_Content(204),
    Reset_Content(205),
    Partial_Content(206),
    Multi_Status(207),
    Already_Reported(208),
    IM_Used(226),
    Multiple_Choice(300),
    Move_Permanently(301),
    Found(302),
    See_Other(303),
    Not_Modified(304),
    Use_Proxy(305),
    Unused(306),
    Temporary_Redirect(307),
    Permanent_Redirect(308),
    Bad_Request(400),
    Unauthorized(401),
    Payment_Required(402),
    Forbidden(403),
    Not_Found(404),
    Method_Not_Allowed(405),
    Not_Acceptable(406),
    Proxy_Authentication_Required(407),
    Request_Timeout(408),
    Conflict(409),
    Gone(410),
    Length_Required(411),
    Precondition_Failed(412),
    Payload_Too_large(413),
    URI_Too_Long(414),
    Unsupported_Media_Type(415),
    Range_Not_Satisfiable(416),
    Expectation_Failed(417),
    Im_A_Teapot(418), //This one pisses me off. What if I want to brew coffee with a teapot??? Did they ever think of that. Lazy Idiots.
    Misdirected_Request(421),
    Unprocessable_Entity(422),
    Locked(423),
    Failed_Dependency(424),
    Too_Early(425),
    Upgrade_Required(426),
    Precondition_Required(428),
    Too_Many_Requests(429),
    Request_Header_Fields_Too_Large(431),
    Unavailable_For_Legal_Reasons(451),
    Internal_Server_Error(500),
    Not_Implemented(501),
    Bad_Gateway(502),
    Service_Unavailable(503),
    Gateway_Timeout(504),
    HTTP_Version_Not_Supported(505),
    Variant_Also_Negotiates(506),
    Insufficient_Storage(507),
    Loop_Detected(508),
    Not_Extended(510),
    Network_Authentication_Required(511);

    private final int value;

    ResponseCode(int _value)
    {
        this.value = _value;
        ResponseCodeMapper.put(_value, this);
    }

    public int getValue()
    {
        return value;
    }

    /**
     * Get the response code associated to an integer value.
     * @param codeValue The integer value to get the response code from.
     * @return The response code associated to the integer.
     */
    public static ResponseCode getResponseCode(int codeValue)
    {
        return ResponseCodeMapper.get(codeValue);
    }
}
