(ns website.content
  (:require
   [reagent.core :as reagent]
   ["bulma-carousel/dist/js/bulma-carousel.min.js" :as bulma-carousel]))

(defn carousel
  [id img-1 img-2 img-3]
  (let [update (fn [comp]
                 (.attach bulma-carousel (str "#" id)
                          (clj->js {:slidesToScroll 1 :slidesToShow 1 :loop true :autoplay true})))]
    (reagent/create-class
     {:reagent-render
      (fn []
        [:div {:class "container notification is-dark"}
          [:div {:id id
                 :class "carousel"}
          [:div {:class "item-1"} [:img {:src img-1}]]
          [:div {:class "item-2"} [:img {:src img-2}]]
          [:div {:class "item-3"} [:img {:src img-3}]]
           ]])
      :component-did-mount update
      :component-did-update update})))

(defn separator
  "Separates components. Takes id so the section is not hidden by menu."
  [id]
  [:div {:class "level"
         :id id}
   [:h5 {:class "is-size-5 is-invisible"}]])

; Navbar
(defn top-nav
  "Top navigation bar with current page name and other pages."
  []
  [:nav {:class      "navbar is-fixed-top"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"} 
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href "/"} "Sammy Shea"]
     [:span {:class       "navbar-burger burger"
             :data-target "menu"}
      ;; spans needed for burger
      [:span][:span][:span]]]

    [:div {:id    "menu"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}
      [:a {:class "navbar-item"
            :href "#overview"} "Overview"]
      [:div {:class "navbar-item has-dropdown is-hoverable"}
       [:a {:class "navbar-link"} "Projects and Classes"]
       [:div {:class "navbar-dropdown"}
        [:a {:class "navbar-item"
             :href "#website-project"} "Website"]
        [:a {:class "navbar-item"
             :href "#tic-tac-toe-project"} "Tic-Tac-Toe"]
        [:a {:class "navbar-item"
             :href "#class-216"} "CSC216 - Software Development"]
        [:a {:class "navbar-item"
             :href "#class-216"} "CSC217 - Lab"]]]]
     [:div {:class "navbar-end"}
      [:span {:class "navbar-item"}
       [:a {:class "button is-rounded is-outlined is-dark is-inverted"
            :href "https://github.com/sgshea/"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]]]
      [:span {:class "navbar-item"}
       [:a {:class "button is-rounded is-outlined is-dark is-inverted"
            :href "https://www.linkedin.com/in/sammy-shea-7350aa1ab"}
        [:span {:class "icon"}
         [:i {:class "fab fa-linkedin"}]]]]]]]]
  )

(defn overview
  "Main content for the main page."
  []
  [:div {:class "container"}
   [:div {:class "section hero is-danger"}
    [:div {:class "hero-body has-text-centered"}
     [:p {:class "title"} "Sammy Shea"]]
    [:p {:class "subtitle"} "Second year student at North Carolina State University majoring in Computer Science."]]
   [:div {:class "sectcion hero is-warning"}
    [:div {:class "hero-body has-text-centered content columns"}
     [:div {:class "column"}
      [:p {:class "subtitle"} "Skills & Interests"]
      [:ul
       [:li [:span {:class "icon"} [:i {:class "fas fa-code"}]] "Programming Languages"
        [:ul
         [:li [:li [:span {:class "icon"} [:i {:class "devicon-java-plain"}]] "Java"]
          [:ul
           [:li "JUnit 5"]
           [:li "SpotBugs/PMD"]
           [:li "JavaFX"]]]
         [:li [:li [:span {:class "icon"} [:i {:class "devicon-clojure-line"}]] "Clojure"]
          [:ul
           [:li "Reagent"]
           [:li "Cljfx"]]]]]
       [:li [:span {:class "icon"} [:i {:class "fas fa-terminal"}]] "Command Line"
        [:ul
         [:li [:span {:class "icon"} [:i {:class "devicon-git-plain"}]] "git/github" [:span {:class "icon"} [:i {:class "devicon-github-original"}]]]
         [:li [:span {:class "icon"} [:i {:class "devicon-bash-plain"}]] "Bash/Zsh"]
         [:li "ssh"]
         [:li [:span {:class "icon"} [:i {:class "devicon-vim-plain"}]] "vim/neovim"]]]]]
     [:div {:class "column"}
      [:ul
       [:li [:span {:class "icon"} [:i {:class "fas fa-laptop"}]] "Operating Systems"
        [:ul 
         [:li [:span {:class "icon"} [:i {:class "fab fa-linux"}]] "Linux"
          [:ul
           [:li [:span {:class "icon"} [:i {:class "fab fa-fedora"}]] "Fedora Linux"]
           [:li [:span {:class "icon"} [:i {:class "fab fa-linux"}]] "Windows Subsystem for Linux"]]]
         [:li [:span {:class "icon"} [:i {:class "fab fa-windows"}]] "Windows"]]]
       [:li [:span {:class "icon"} [:i {:class "fas fa-keyboard"}]] "Editors"
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "Eclipse IDE"]
         [:li [:span {:class "icon"} [:i {:class "devicon-vscode-plain"}]] "Visual Studio Code"]]]
       [:li [:span {:class "icon"} [:i {:class "fas fa-dragon"}]] "Other"
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fab fa-html5"}]] "HTML"]
         [:li [:span {:class "icon"} [:i {:class "fab fa-css3"}]] "CSS3"]
         [:li [:span {:class "icon"} [:i {:class "fab fa-sass"}]] "Sass"]
         [:li [:span {:class "icon"} [:i {:class "devicon-bulma-plain"}]] "Bulma"]]]]
      ]]]])

(defn website-project
  []
  [:div {:class "columns"}
   [:div {:class "section box"}
     [:div {:class "tile is-ancestor"} ; ancestor tile
      [:div {:class "tile is-parent is-vertical"}  ; left grouping
       [:div {:class "tile is-child notification is-primary columns"}
        [:p {:class "title column"} "Custom Portfolio Website"]
        [:a {:class "button is-rounded is-dark is-inverted is-outlined"
               :href "https://github.com/sgshea/website"}
           [:span {:class "icon"}
            [:i {:class "fab fa-github"}]]]]
       [:div {:class "tile is-child notification is-warning content"}
        [:p {:class "subtitle"} "Overview"]
        [:p "Created to show off my work online in a presentable format!"]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fas fa-user"}]] "Personal Project"]
         [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Created Summer 2022"]
         [:li [:span {:class "icon"} [:i {:class "fas fa-code"}]] "Created in ClojureScript"]
         ]]]
      [:div {:class "tile is-parent is-vertical"} ; right grouping
       [:div {:class "tile is-child notification is-success content"}
        [:p {:class "subtitle has-text-centered"} "Technologies Used"] 
        [:ul
         [:li 
          [:a {:href "https://clojurescript.org"} "ClojureScript"]
          [:p "ClojureScript is a compiler to JavaScript for the functional language Clojure.
               In the website ClojureScript was used for all of the coding, including interactable parts
               such as the theme switcher, and for writing HTML with Reagent, or CSS with Bulma."]]
         [:li
          [:a {:href "https://reagent-project.github.io"} "Reagent"]
          [:p "Reagent is an interface between ClojureScript and React.js, it provided ways to easily create
               the GUI using HTML and CSS, as well as manage the more complex state."]]
         [:li
          [:a {:href "https://bulma.io"} "Bulma"]
          [:p "Bulma is a pure CSS framework that provides many CSS classes to create a beautiful layout including
               the navbar, and project showcases."]]
         [:li
          [:a {:href "https://sass-lang.com"} "Sass"]
          [:p "Sass is a CSS extension language which Bulma uses to manage variables,
               and is how the website's theme colors are defined."]]]]
       ]]]])

(defn tic-tac-toe-project
  []
  [:div {:class "columns"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; top grouping
      [:div {:class "tile is-child notification is-primary columns"}
       [:p {:class "title column"} "Tic-Tac-Toe"]
       [:a {:class "button is-rounded is-dark is-inverted is-outlined"
            :href "https://github.com/sgshea/tic-tac-toe"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]]]
      [:div {:class "tile is-child notification is-warning content"}
       [:p {:class "subtitle"} "Overview"]
       [:p "Created to learn Clojure, and explore GUI programming!"]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fas fa-user"}]] "Personal Project"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Created Summer 2022"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-code"}]] "Created in Clojure"]]]] 
     [:div {:class "tile is-child"} ; carousel
      [(carousel "tic-tac-toe" "images/ttt-image-1.png" "images/ttt-image-2.png" "images/ttt-image-3.png")]]
     [:div {:class "tile is-parent is-vertical"} ; bottom grouping
      [:div {:class "tile is-child notification is-success content"}
       [:p {:class "subtitle has-text-centered"} "Technologies Used"]
       [:ul
        [:li
         [:a {:href "https://clojure.org"} "Clojure"]
         [:p "Clojure is a functional lisp that runs on the Java Virtual Machine (JVM).
              This project was used to learn Clojure, the logic of the tic-tac-toe game was created in Clojure."]]
        [:li
         [:a {:href "https://github.com/cljfx/cljfx"} "Cljfx"]
         [:p "Library which wraps JavaFX in a declaritive, functional style similar to React/Reagent.
              This was the first time I really used any GUI library, and I tried to adhere to the model-view-controller
              design pattern by keeping most of the Clojure logic seperate from the GUI programming."]]]]]]]])

(defn class-216
  []
  [:div {:class "columns"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; top grouping
      [:div {:class "tile is-child notification is-danger columns title"}
       [:span {:class "icon"} [:i {:class "fas fa-graduation-cap"}]] "CSC216 - Software Development Fundamentals"]
      [:div {:class "tile is-child notification is-warning content"}
       [:p {:class "subtitle"} "Overview"]
       [:p "Second semester programming course at NC State Universiy. This class was is in the Java programming language, and explored
            the Object-oriented programming paradigm. Linear data structures such as array-lists and linked-lists were a heavy focus
            as well as finite state machines and recursion."]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Completed Spring 2022"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-code"}]] "Java Programming Language"]]]]
      [:div {:class "tile is-parent"} ; middle grouping
       [:div {:class "tile is-child notification is-link content is-5"}
        [:p {:class "subtitle has-text-centered"} "Project 1 - Ticket Manager"]
        [:p "The first project involved creating a finite state machine for a Ticket Manager system.
            The work done by the student involved creating the finite state machine for the issues as they are transfered from a new issue to a closed issue."]
        [:ul
         [:li "The issues were represented as subclasses and used polymorphism to be handled by a IssueManager class."]]]
       [:div {:class "tile is-child"}] ; dummy tile in between projects
       [:div {:class "tile is-child notification is-link content is-5"}
        [:p {:class "subtitle has-text-centered"} "Project 2 - Task List"]
        [:p "The Tasks project involved handling lists of tasks by adding, moving, deleting, and exporting them."]
        [:ul
         [:li "Tasks were represented in a custom array-list, while task lists were represented as a custom sorted linked-list."]
         [:li "This project was very focused on interactions of array and linked-lists in a study of Java collections."]]]]
     [:div {:class "tile is-parent is-vertical"} ; bottom grouping
      [:div {:class "tile is-child notification is-success content"}
       [:p {:class "subtitle has-text-centered"} "Technologies Used"]
       [:ul
        [:li "Software Development"
         [:ul
          [:li "Eclipse Integrated Development Environment"
           [:p "In this class we used the Eclipse IDE for Java development. Over the semester many features and plugins
                of Eclipse were used to debug, analyze, and run code."]]
          [:li "GitHub"
           [:p "Projects were stored on GitHub for version control."]]
          [:li "Project Design"
           [:p "Both major projects required design stages with UML class diagrams and design proposals."]]]]
        [:li "Software Testing"
         [:ul
          [:li "JUnit"
           [:p "Unit testing was done through the JUnit 5 Java testing framework. Test-driven
                development was encouraged through code coverage requirements."]]
          [:li "Static Analysis"
           [:p "Static analysis was done through the SpotBugs static code analyzer and PMD source code analyzer."]]
          [:li "Jenkins Continuous Integration"
           [:p "A Teaching Staff Jenkins server was used to test and grade submissions through GitHub."]]]]]]]
    ]]])

(defn class-217
  []
  [:div {:class "columns"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; top grouping
      [:div {:class "tile is-child notification is-danger columns title"}
       [:span {:class "icon"} [:i {:class "fas fa-graduation-cap"}]] "CSC217 - Software Development Fundamentals Lab"]
      [:div {:class "tile is-child notification is-warning content"}
       [:p {:class "subtitle"} "Overview"]
       [:p "This Lab accompanied CSC216 - Software Development Fundamentals. A single semester-long project was worked on in the lab
            with a team of 3-4, though the teams were randomized every 4 weeks, for a total of 3 different teams on the same project.
            This helped teach additional concepts such as pair programming, and put more importance on collaborative tools such as GitHub, documentation,
            and testing in order to work within a team."]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Completed Spring 2022"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-code"}]] "Java Programming Language"]]]]
     [:div {:class "tile is-parent"} ; middle grouping
      [:div {:class "tile is-child notification is-link content"}
       [:p {:class "subtitle has-text-centered"} "Project - Scheduler"]
       [:p "The lab's project was a scheduler, with the ability to add users, enroll them in classes, setup instructors, and export/import saved schedules."]
       [:ul
        [:li "Many of the same technologies were used as in CSC216, and the lab was focused on implementing each week's lecture topics."
         [:ul
          [:li "Object Oriented design such as inheritance, abstract/interface classes, and polymorphism was explored."]
          [:li "Software Development design was used heavily in collaboration with frequent requirements analysis, implmentations, and testing."]]]]]]
     ]]])