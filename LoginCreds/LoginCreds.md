Folder structure diagram for the source files contained here:

LoginCreds ->
    src ->
        main ->
         |_ java ->
            |   matt ->
            |       creds ->
            |           HibernateUtil.java
            |           User.java
            |           UesrDAO.java
            |       
            |       serv ->
            |           RegisterServlet.java
            |           Success.java
            |           UserExists.java
            |           VerifyServlet.java
            |           Welcome.java
            |           
            webapp ->
                WEB-INF ->
                    web.xml
                index.jsp
                loginError.jsp
                loginUser.jsp
                regSuccess.jsp
                regUser.jsp
                userExists.jsp
                welcome.jsp
                (several .jpeg files used in the UI)
