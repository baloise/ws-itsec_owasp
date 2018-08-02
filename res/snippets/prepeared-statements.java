String custname = request.getParameter("customerName");

String query = "SELECT account_balance FROM user_data WHERE user_name = ? ";
PreparedStatement pstmt = connection.prepareStatement( query );

pstmt.setString( 1, custname);
ResultSet results = pstmt.executeQuery( );

src (modified): owasp.org