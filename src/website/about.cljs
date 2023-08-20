(ns website.about)

(defn nav-bar []
  [:div {:class "navbar bg-primary text-primary-content"}
   [:div {:class "flex-1"}
    [:a {:class "btn btn-ghost normal-case text-xl"}
     "Sammy Shea"]]
   [:div {:class "flex-none"}
    [:div {:class "dropdown dropdown-bottom dropdown-end"}
     [:label {:tabindex "0" :class "btn btn-ghost m-1"} "Projects"]
     [:li {:tabindex "0" :class "dropdown-content menu shadow mt-3 z-[1] p-2 rounded-box w-52"}
      [:ul
       [:li [:a "Rust NEAT"]]
       [:li [:a "Clojure FullStack"]]]]]]])

(defn main-paragraph []
  [:article {:class "prose"}
   [:h1
    "About"]
   [:p
    "Hi, my name is Sammy! I currently am studying Computer Science at the University of North Carolina.
     I am interested in open-source spaces such as Linux, as well as topics such as artifical intelligence and exploring different programming languages or paradigms!"]
   ])

(defn main []
[:div
 [nav-bar]
 [:div {:class "flex justify-center items-center mt-5"}
  [main-paragraph]]])
