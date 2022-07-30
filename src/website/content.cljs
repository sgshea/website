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
  [:nav {:class      "navbar is-fixed-top is-dark"
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
      [:a {:class "navbar-item"
           :href  "#projects"} "Projects"]
      [:span {:class "navbar-item"}
       [:a {:class "button is-inverted"
            :target "_blank"
            :href "https://github.com/sgshea/"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "My Github"]]]]]]]
  )

(defn overview
  "Main content for the main page."
  []
  [:div {:class "container is-fluid"} 
   [:div {:class "notification is-primary"}
   [:h1 "Overview"]]
   [:p "I am a student at North Carolina State University studying computer science."]])

(defn projects
  "Contains my projects."
  []
  [:div {:class "container is-fluid"}
   [:div {:class "notification is-primary"}
    [:h2 "Projects Showcase"]]
   [:p "These are my projects completed either in class or as personal learning projects"]
   ; Project Section Template 3-box layout
   [:div {:class "section"}
    [:div {:class "notification is-primary"}
     [:h3 "Project"]]
    [:div {:class "tile is-ancestor"}
     [:div {:class "tile is-4 is-vertical is-parent"}
      [:div {:class "tile is-child box"}
       [:h2 "Project"]]
      [:div {:class "tile is-child box"}
       [:h2 "Picture"]]]
     [:div {:class "tile is-parent"}
      [:div {:class "tile is-child box"}
      [:p {:class "title"} "Description"]
      [:p "Lorem Ipsum"]]]]]])


