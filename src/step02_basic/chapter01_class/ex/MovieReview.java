package step02_basic.chapter01_class.ex;

public class MovieReview {
        protected String title;
        protected String review;
        public MovieReview(String title,String review){
            this.title=title;
            this.review=review;
        }
        public MovieReview(){}
        protected void printReview(){
            System.out.println("영화 제목: "+title+", 리뷰: "+review);
        }

}
