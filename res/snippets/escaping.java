Codec ORACLE_CODEC = new OracleCodec(); //added
String query = "SELECT user_id FROM user_data WHERE user_name = '" +

    ESAPI.encoder().encodeForSQL( ORACLE_CODEC, //added
    req.getParameter("userID") ) + "' and user_password = '" +
    ESAPI.encoder().encodeForSQL( ORACLE_CODEC, //added
    req.getParameter("pwd") ) +"'";

// src: owasp.org