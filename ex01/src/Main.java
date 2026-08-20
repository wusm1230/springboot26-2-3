public static Optional<String> getName(){
    return Optional.of("홍길동");
}

void main() {
    System.out.println("안녕하세요 우성민입니다");
    String name = null;
    try {
        if(name != null){
            System.out.println("name.length()" + name.length());
        }
        System.out.println("name.length()" + name.length());
    } catch (Exception e) {
//        e.printStackTrace();
    }
    Optional<String> optional = getName();
    optional.ifPresent(s -> System.out.println(s.length()));
}
