package com.revature.project1.servlets;

@WebServlet("/usreimb")
public class UserReimbServlet extends HttpServlet {

    ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try{
            User user = mapper.readValue(req.getInputStream(), User.class);
            Set<Reimbursement> reimbursements = reimbService.getReimbursementsByUserId(user.getId());
            String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
            resp.getWriter().write(reimbursementsJSON);
            resp.setStatus(201);
        } catch (MismatchedInputException e){
            resp.setStatus(400);
        } catch (AuthenticationException e){
            resp.setStatus(401);
        } catch (Exception e) {
            resp.setStatus(500);
        }

    }

}
