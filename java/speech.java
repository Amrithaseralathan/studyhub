/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ARUN
 */
@WebServlet(urlPatterns = {"/speech"})
public class speech extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.getRequestDispatcher("notes.html").include(request, response);
            String notes=request.getParameter("get");
            String action=request.getParameter("b1");
          
            try {
			// Set property as Kevin Dictionary
			System.setProperty(
				"freetts.voices",
				"com.sun.speech.freetts.en.us"
					+ ".cmu_us_kal.KevinVoiceDirectory");

			// Register Engine
			Central.registerEngineCentral(
				"com.sun.speech.freetts"
				+ ".jsapi.FreeTTSEngineCentral");

			// Create a Synthesizer
			Synthesizer synthesizer
				= Central.createSynthesizer(
					new SynthesizerModeDesc(Locale.US));

			// Allocate synthesizer
			synthesizer.allocate();
                        
			// Resume Synthesizer
			synthesizer.resume();

			// Speaks the given text
			// until the queue is empty.
                    // File file = new File("D://Sample.pdf");
                    
      // PDDocument document = PDDocument.load(file);
                   if(action.equals("stop")){
                     synthesizer.pause();
            }
                    synthesizer.speakPlainText(
				notes, null);
			synthesizer.waitEngineState(
				Synthesizer.QUEUE_EMPTY);
                  
			// Deallocate the Synthesizer.
			synthesizer.deallocate();
               
                     
                      
                      //System.out.println(textspeech);
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
