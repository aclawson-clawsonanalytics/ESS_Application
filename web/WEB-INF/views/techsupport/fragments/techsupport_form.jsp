<%-- 
    Document   : techsupport_form
    Created on : Jun 13, 2016, 8:07:24 PM
    Author     : andrewclawson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <div class="blog-post" align="center">
        <p>
            Welcome to the MAX School Solutions tech support page. We are eager to answer any questions you
            may have or to serve you in any way we can to help you get back on your feet with the app. If you have
            landed here by mistake, feel free to <a>login here</a> or <a>visit our web site</a> for more details about
            our product and services. Otherwise, drop us a line and a representative will be with you shortly. Please
            make sure to leave a detailed message and a phone number where you can be reached.
        </p>
    </div>
    
        <div class="callout row techsupport-form">
            <form id="techsupport-form">
                <label><b>Email:</b></label>
                    <input type="email" placeholder="${pageContext.session.getAttribute('activeUser').getEmail()}">
                    <textarea rows="10" name="comment" form="techsupport-form" placeholder="How can we assist you today?">
                        
                    </textarea>
                    <a class="button">Contact Tech Support</a>
            </form>

        
        </div>
</html>

