(ns website.about)

(defn carousel-item [image-url]
  [:div {:class "carousel-item rounded-box h-fit w-fit"}
   [:img {:src image-url}]])

(defn project-template [id title text images]
   [:div {:class "card container mx-auto lg:card-side bg-primary mb-5"}
   [:figure
    [:img {:src (first images)}]]
    [:div {:class "card-body"}
     [:h2 {:class "card-title"} title]
     text
     [:div {:class "card-actions justify-end"}
      [:button {:class "btn btn-secondary"
                :on-click #((-> js/document
                                (.getElementById id)
                                (.showModal)))} "More Images"]]
      [:dialog {:id id :class "modal"}
       [:form {:method "dialog" :class "modal-box max-w-none h-3/5 w-2/3"}
        [:div {:class "carousel bg-neutral rounded-box"}
         (map carousel-item images)]
        [:div {:class "modal-action"}
         [:button {:class "btn btn-secondary"} "Close"]]
        ]]
     ]])

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
  [:article {:class "prose mb-10"}
   [:h1
    "About"]
   [:p
    "Hi, my name is Sammy! I currently am studying Computer Science at the University of North Carolina.
     I am interested in open-source spaces such as Linux, as well as topics such as artifical intelligence and exploring different programming languages or paradigms!"]
   ])

(def neat-project
  [project-template
   "RNI"
  "Rust NEAT Implementation"
   [:article {:class "prose"}
    [:p "Implementation of the Neuroevolution of Augmenting Topologies (NEAT) machine learning algorithm in the Rust programming language."
     ]]])

(def clojure-fullstack
  [project-template
   "CFS"
  "Clojure Fullstack Ecommerce Application"
   [:article {:class "prose"}
    [:p "Fullstack application written in Clojure/ClojureScript."]]
   '("images/ecom_1.png" "images/ecom_2.png" "images/ecom_3.png" "images/ecom_4.png" "images/ecom_5.png" "images/ecom_6.png")])

(defn main []
[:div
 [nav-bar]
 [:div {:class "flex flex-col items-center mt-5"}
  [main-paragraph]
  neat-project
  clojure-fullstack
  ]])
