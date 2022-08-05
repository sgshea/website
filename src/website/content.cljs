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
             :href "#website-project"} "Website"]]]]
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
          [:p "Used for the interactable parts such as the theme switcher!"]]
         [:li
          [:a {:href "https://reagent-project.github.io"} "Reagent"]
          [:p "Manages state and provides React components!"]]
         [:li
          [:a {:href "https://bulma.io"} "Bulma"]
          [:p "CSS framework used to build the layout, navbar, and more!"]]
         [:li
          [:a {:href "https://sass-lang.com"} "Sass"]
          [:p "CSS extension to manage the color theming!"]]]]
       ]]]])


