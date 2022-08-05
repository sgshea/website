(ns website.content)

(defn separator
  "Separates components. Takes id so the section is not hidden by menu."
  [id]
  [:div {:class "level"
         :id id}
   [:h5 {:class "is-size-5 is-invisible"}
    id]])

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
       [:a {:class "navbar-link"} "Projects"]
       [:div {:class "navbar-dropdown"}
        [:a {:class "navbar-item"
             :href "#website-project"} "Website"]
        [:a {:class "navbar-item"
             :href "#tic-tac-toe-project"} "Tic-Tac-Toe"]]]]
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
  [:div {:class "section hero is-danger"} 
   [:div {:class "hero-body has-text-centered"}
   [:p {:class "title"} "I am Sammy Shea"]]
   [:p {:class "subtitle"}"Second year student at North Carolina State University studying computer science."]])

(defn website-project
  []
  [:div {:class "container"}
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
  [:div {:class "container"}
   [:div {:class "section box"}
    [:div {:class "tile is-ancestor"} ; ancestor tile
     [:div {:class "tile is-parent is-vertical"}  ; left grouping
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
     [:div {:class "tile is-parent is-vertical"} ; right grouping
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
