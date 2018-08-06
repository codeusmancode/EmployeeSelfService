package essp.usg.view.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.sun.media.jai.codec.FileSeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.JPEGEncodeParam;
import com.sun.media.jai.codec.SeekableStream;
import com.sun.media.jai.codec.TIFFDecodeParam;

import java.awt.image.RenderedImage;

import java.io.FileOutputStream;

@WebServlet(name = "ShowImageServlet", urlPatterns = { "/showimageservlet" })
public class ImageServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "image/png; charset=utf-8";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emp_code = request.getParameter("emp_code").toString();

        response.setContentType(CONTENT_TYPE);
        OutputStream out = response.getOutputStream();


        //File file = new File("A:\\"+emp_code+".jpg");//\\usgtms\USG_EMP_PICS windows
        File file = new File("//home//oracle//Desktop//emp_pics//" + emp_code + ".jpg"); // linux
//        if (!file.exists()) {
//            SeekableStream s =
//                new FileSeekableStream(new File("//home//oracle//Desktop//emp_pics//" + emp_code + ".tif"));
//
//            TIFFDecodeParam param = null;
//            ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
//            RenderedImage op = dec.decodeAsRenderedImage(0);
//
//            FileOutputStream fos = new FileOutputStream("//home//oracle//Desktop//emp_pics//" + emp_code + ".jpg");
//            JPEGEncodeParam jpgparam = new JPEGEncodeParam();
//            jpgparam.setQuality(67);
//            ImageEncoder en = ImageCodec.createImageEncoder("jpeg", fos, jpgparam);
//            en.encode(op);
//            fos.flush();
//            fos.close();
//        }
//        file = new File("//home//oracle//Desktop//emp_pics//" + emp_code + ".jpg");
        if (file.exists()) {
            FileInputStream input = null;
            try {
                input = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bytes = new byte[10240];
                while (bis.read(bytes, 0, 10240) != -1) {
                    out.write(bytes);
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
                if (input != null) {
                    input.close();
                }

            }
        } else {
            File noimage = new File("\\\\usgtms\\USG_EMP_PICS\\noimage.png");
            FileInputStream input = null;
            try {
                input = new FileInputStream(noimage);
                BufferedInputStream bis = new BufferedInputStream(input);
                byte[] bytes = new byte[10240];
                while (bis.read(bytes, 0, 10240) != -1) {
                    out.write(bytes);
                }
                out.flush();
            } catch (Exception e) {
               System.out.println("ImageServlet.java: "+e.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
                if (input != null) {
                    input.close();
                }

            }
        }
    }
}
