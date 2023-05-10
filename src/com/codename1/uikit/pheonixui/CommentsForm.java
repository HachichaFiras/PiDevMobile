/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.codename1.uikit.pheonixui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.uikit.pheonixui.entity.Blog;
import com.codename1.uikit.pheonixui.entity.Comments;
import com.codename1.uikit.pheonixui.service.BlogService;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class CommentsForm extends BaseForm {

  /* public CommentsForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public CommentsForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
       
   
        
        ScaleImageLabel sl = new ScaleImageLabel(resourceObjectInstance.getImage("skate-park.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        sl = new ScaleImageLabel(resourceObjectInstance.getImage("bridge.jpg"));
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        
        installSidemenu(resourceObjectInstance);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {});
        
      
    }

   


    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance,Blog b) {
        
        List<Comments> cmt = Comm
        List<Blog> blogs = BlogService.getInstance().getAllTasks();
         setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Commentaire");
        setName("TrendingForm");
        int i=0;
        for(Blog b : blogs)
        {i++;
            com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
   com.codename1.components.MultiButton gui_Multi_Button_1 = new com.codename1.components.MultiButton();
    com.codename1.components.MultiButton gui_LA = new com.codename1.components.MultiButton();
    com.codename1.ui.Container gui_imageContainer1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
     com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
     com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
     com.codename1.ui.Label gui_separator1 = new com.codename1.ui.Label();
     gui_LA.setIconPosition(BorderLayout.EAST);

       gui_separator1.setShowEvenIfBlank(true);
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setGrowByContent(false);
        gui_Text_Area_1.setEditable(false);
           
       
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1_"+i);
                gui_imageContainer1.setInlineStylesTheme(resourceObjectInstance);
        gui_imageContainer1.setName("imageContainer1_"+i);
        gui_separator1.setUIID("Separator");
                gui_separator1.setInlineStylesTheme(resourceObjectInstance);
        gui_separator1.setName("separator1");
             
        addComponent(gui_Container_1);
        gui_Multi_Button_1.setUIID("Label");
                gui_Multi_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Multi_Button_1.setName("Multi_Button_1"+i);
        gui_Multi_Button_1.setIcon(resourceObjectInstance.getImage("contact-c.png"));
        gui_Multi_Button_1.setPropertyValue("line1", b.getTitle());
        gui_Multi_Button_1.setPropertyValue("line2", "@"+b.getTitle());
        gui_Multi_Button_1.setPropertyValue("uiid1", "Label");
        gui_Multi_Button_1.setPropertyValue("uiid2", "RedLabel");
        gui_LA.setUIID("Label");
                gui_LA.setInlineStylesTheme(resourceObjectInstance);
        gui_LA.setName("LA");
        gui_LA.setPropertyValue("line1", b.getDateCreation().toString());
        gui_LA.setPropertyValue("line2", "GMS+1");
        gui_LA.setPropertyValue("uiid1", "SlightlySmallerFontLabel");
        gui_LA.setPropertyValue("uiid2", "RedLabelRight");
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Multi_Button_1);
        gui_Container_1.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_LA);
        addComponent(gui_imageContainer1);
                gui_Container_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_2.setName("Container_2_"+i);
        gui_imageContainer1.addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_2);
        gui_Text_Area_1.setText(b.getContenu());
        gui_Text_Area_1.setUIID("SlightlySmallerFontLabelLeft");
                gui_Text_Area_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area_1.setName("Text_Area_1_"+i);
        gui_Button_1.setText("");
        gui_Button_1.setUIID("Label");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1_"+i);
        
        
        
        
        
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Text_Area_1);
        gui_Container_2.addComponent(com.codename1.ui.layouts.BorderLayout.EAST, gui_Button_1);
        addComponent(gui_separator1);
        }
    }


    @Override
    protected boolean isCurrentTrending() {
        return true;
    }*/
}
