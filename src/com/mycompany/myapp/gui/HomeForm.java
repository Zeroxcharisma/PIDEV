/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form {

    Form current;
    private Resources theme;
    
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public HomeForm() {
        theme =UIManager.initFirstTheme("/theme");
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add User");
        Button btnListTasks = new Button("List Users");
        Button btnUpdateTasks = new Button("Update User");
        Button btnDeleteTasks = new Button("Delete User");
        

        btnAddTask.addActionListener(e -> new AddTaskForm(current).show());
        btnListTasks.addActionListener(e -> new ListTasksForm(theme).show());
        btnUpdateTasks.addActionListener(e -> new UpdateTasksForm(current).show());
     
       // btnDeleteTasks.addActionListener(e -> new DeleteTasksForm(current).show());
        addAll(btnAddTask, btnListTasks,btnUpdateTasks,btnDeleteTasks);

    }

}
