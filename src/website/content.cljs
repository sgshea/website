(ns website.content
  (:require
   [reagent.core :as r]
   ["bulma-carousel/dist/js/bulma-carousel.min.js" :as bulma-carousel]))

(defn carousel
  [id img-1 img-2 img-3]
  (let [update (fn []
                 (.attach bulma-carousel (str "#" id)
                          (clj->js {:slidesToScroll 1 :slidesToShow 1 :loop true :autoplay true})))]
    (r/create-class
     {:reagent-render
      (fn []
        [:div {:class "container box is-dark"}
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
  [theme-button]
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
        ]]]
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
         [:i {:class "fab fa-linkedin"}]]]]
     ;;  [:span {:class "navbar-item"}
     ;;   [theme-button]]
      ]]]])

(defn overview
  "Main content for the main page."
  []
  [:div {:class "container"}
   [:div {:class "section box"}
     [:h1 {:class "title has-text-justified"} "Sammy Shea"]
    [:h2 "Second year student at North Carolina State University majoring in Computer Science."]]
   [:div {:class "container box content columns"}
     [:div {:class "column"}
      [:h1 {:style {:color "#fb4934"}}"Experience Overview"]
      [:ul
       [:li [:p {:style {:color "#b8bb26"}} 
             [:span {:class "icon"} [:i {:class "fas fa-code"}]] 
             "Programming Languages"]
        [:ul
         [:li [:p {:style {:color "#fabd2f"}}
               [:span {:class "icon"} [:i {:class "devicon-java-plain"}]]
               "Java"]]
          [:ul
           [:li "JUnit 5"]
           [:li "SpotBugs/PMD"]
           [:li "JavaFX"]]
         [:li [:p {:style {:color "#fabd2f"}}
               [:span {:class "icon"} [:i {:class "devicon-clojure-line"}]]
               "Clojure"]
          [:ul
           [:li "Reagent"]
           [:li "Cljfx"]]]]]
       [:li [:p {:style {:color "#b8bb26"}}
             [:span {:class "icon"} [:i {:class "fas fa-terminal"}]]
             "Command Line"]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "devicon-git-plain"}]] "git/github" [:span {:class "icon"} [:i {:class "devicon-github-original"}]]]
         [:li [:span {:class "icon"} [:i {:class "devicon-bash-plain"}]] "Bash/Zsh"] 
         [:li [:span {:class "icon"} [:i {:class "devicon-vim-plain"}]] "vim/neovim"]
         [:li "ssh"]]]]]
     [:div {:class "column content has-text-centered"}
      [:ul
       [:li [:p {:style {:color "#b8bb26"}}
             [:span {:class "icon"} [:i {:class "fas fa-laptop"}]]
             "Operating Systems"]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fab fa-linux"}]] "Linux"
          [:ul
           [:li [:span {:class "icon"} [:i {:class "fab fa-fedora"}]] "Fedora Linux"]
           [:li [:span {:class "icon"} [:i {:class "fab fa-linux"}]] "Windows Subsystem for Linux"]]]
         [:li [:span {:class "icon"} [:i {:class "fab fa-windows"}]] "Windows"]]]
       [:li [:p {:style {:color "#b8bb26"}}
             [:span {:class "icon"} [:i {:class "fas fa-keyboard"}]]
             "Editors"]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "Eclipse IDE"]
         [:li [:span {:class "icon"} [:i {:class "devicon-vscode-plain"}]] "Visual Studio Code"]]]
       [:li [:p {:style {:color "#b8bb26"}}
             [:span {:class "icon"} [:i {:class "fas fa-dragon"}]]
             "Other"]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fab fa-html5"}]] "HTML"]
         [:li [:span {:class "icon"} [:i {:class "fab fa-css3"}]] "CSS3"]
         [:li [:span {:class "icon"} [:i {:class "fab fa-sass"}]] "Sass"]
         [:li [:span {:class "icon"} [:i {:class "devicon-bulma-plain"}]] "Bulma"]]]]]]
    [:div {:class "container box columns"} 
      [:div {:class "column content has-text-centered"}
       [:h3 {:style {:color "#fb4934"}} "Completed Computer Science Courses"]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "CSC116 - Introduction to Computing - Java"]
        [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "CSC216 - Software Development Fundamentals"]
        [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "CSC217 - Software Development Fundamentals Lab"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-brain"}]] "CSC226 - Discrete Mathematics for Computer Scientists"]]]
      [:div {:class "column content has-text-centered"}
       [:h4 {:style {:color "#8ec07c"}} "In Progress Courses"]
       [:ul
        [:li "Fall 2022"
         [:ul
          [:li [:span {:class "icon"} [:i {:class "devicon-c-plain"}]] "C and Software Tools"]
          [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "Data Structures and Algorithms"]
          [:li [:span {:class "icon"} [:i {:class "fas fa-brain"}]] "Automata, Grammars, and Computability"]]]]]
      ]])

(defn website-project
  []
  [:div {:class "container columns"}
   [:div {:class "section box"}
     [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile 
      [:div {:class "tile is-parent is-vertical"}  ; left grouping
       [:div {:class "tile is-child box columns"}
        [:h1 {:class "title column"} "Portfolio Website"]
        [:a {:class "button is-rounded is-dark is-inverted is-outlined"
             :href "https://github.com/sgshea/website"}
         [:span {:class "icon"}
          [:i {:class "fab fa-github"}]]]]
       [:div {:class "tile is-child content box"}
        [:p {:class "subtitle"} "Overview"]
        [:p "Website created in order to present my personal projects and classwork.
             I used ClojureScript for this project as I was recently learning Clojure and interested in trying it's web capabilities and ecosystem such as Reagent."]
        [:ul
         [:li [:span {:class "icon"} [:i {:class "fas fa-user"}]] "Personal Project"]
         [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Created Summer 2022"]
         [:li [:span {:class "icon"} [:i {:class "devicon-clojurescript-plain"}]] "Created in ClojureScript"]]]]
      [:div {:class "tile is-parent is-vertical"} ; right grouping
       [:div {:class "tile is-child box is-success content"}
        [:p {:class "subtitle has-text-centered"} "Technologies Used"] 
        [:ul
         [:li 
          [:a {:href "https://clojurescript.org"} "ClojureScript"]
          [:p "ClojureScript is Clojure compiled to JavaScript, allowing it to be used for web development."]]
         [:li
          [:a {:href "https://reagent-project.github.io"} "Reagent"]
          [:p "Reagent is an interface between ClojureScript and React.js, it provided ways to easily define
               HTML and CSS in ClojureScript, as well as manage the more complex state."]]
         [:li
          [:a {:href "https://bulma.io"} "Bulma"]
          [:p "Bulma is pure CSS framework, providing nice and responsive elements such as the navbar and other elements."]]
         [:li
          [:a {:href "https://sass-lang.com"} "Sass"]
          [:p "Sass is a CSS extension, giving a good way to define more complex variables for colors and elements."]]]]
       ]]]])

(defn tic-tac-toe-project
  []
  [:div {:class "container columns"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; top grouping
      [:div {:class "tile is-child box is-primary columns"}
       [:p {:class "title column"} 
        "Tic-Tac-Toe Program"]
       [:a {:class "button is-rounded is-dark is-inverted is-outlined"
            :href "https://github.com/sgshea/tic-tac-toe"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]]]
      [:div {:class "tile is-child box is-warning content"}
       [:p {:class "subtitle"} "Overview"]
       [:p "Tic-Tac-Toe game created with Clojure with additional feature of allowing user to redefine board size.
            Cross platform using the Java Virtual Machine including Graphical User Interface made with Cljfx library."]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fas fa-user"}]] "Personal Project"]
        [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Created Summer 2022"]
        [:li [:span {:class "icon"} [:i {:class "devicon-clojure-line"}]] "Created in Clojure"]]]] 
     [:div {:class "tile is-child"} ; carousel
      [(carousel "tic-tac-toe" "images/ttt-image-1.png" "images/ttt-image-2.png" "images/ttt-image-3.png")]]
     [:div {:class "tile is-parent is-vertical"} ; bottom grouping
      [:div {:class "tile is-child box is-success content"}
       [:p {:class "subtitle has-text-centered"} "Technologies Used"]
       [:ul
        [:li
         [:a {:href "https://clojure.org"} "Clojure"]
         [:p "Clojure is a functional lisp that runs on the Java Virtual Machine (JVM).
              Game logic created as a learning experience in Clojure."]]
        [:li
         [:a {:href "https://github.com/cljfx/cljfx"} "Cljfx"]
         [:p "Library which wraps JavaFX in a declaritive, functional style similar to React/Reagent.
              Cljfx used to provide a graphical interface after majority of game logic created for a command-line interface."]]]]]]]])

(defn class-216
  []
  [:div {:class "columns"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor is-vertical"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; top grouping
      [:div {:class "tile is-child box columns title"} 
       "CSC216 - Software Development Fundamentals"]
      [:div {:class "tile is-child box content"}
       [:p {:class "subtitle"} "Overview"]
       [:p "Second semester programming course, this helped me develop skills in more advanced topics.
            The course focused on object-oriented concepts such as inheritance and encapsulation. Other topics such as
            basic collections like array-based and linked lists were also explored."]
       [:ul
        [:li [:span {:class "icon"} [:i {:class "fas fa-calendar"}]] "Completed Spring 2022"]
        [:li [:span {:class "icon"} [:i {:class "fab fa-java"}]] "Java Programming Language"]]]]
      [:div {:class "tile is-parent"} ; middle grouping
       [:div {:class "tile is-child box content is-5"}
        [:p {:class "subtitle has-text-centered"} "Class Projects"]
        [:ol
         [:li "Ticket Manager project using finite state machine to handle ticket transitions.
               Focus on object oriented concepts such as polymorphism and subclasses for the finite state machine."]
         [:li "Task List project involving a notebook with lists of tasks. Different custom collections such as array-based
               and linked-lists to manage tasks and lists of task lists with efficiency."]]]
       [:div {:class "tile is-child"}] ; dummy tile in between projects
       [:div {:class "tile is-child box content is-5"}
        [:p {:class "subtitle has-text-centered"} "CSC217 Lab"]
        [:p "Lab accompanying the class involving a single semester-long project. The lab project was done within a team of
             3-4, with teams changed every 4 weeks."]
        [:ul
         [:li "Similar topics as class: Exploring applications of inheritance and polymorphism, and custom collections."]
         [:li "Focus on software development best practices such as collabrative design documents, documentation, pair programming, and collaboration with git."]]]]
    ]]])