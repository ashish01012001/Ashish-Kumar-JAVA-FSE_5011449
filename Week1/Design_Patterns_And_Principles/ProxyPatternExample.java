package Week1.Design_Patterns_And_Principles;

interface Image {
    void display();
}

class RealImage implements Image {
    private String imageUrl;

    public RealImage(String imageUrl) {
        this.imageUrl = imageUrl;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from " + imageUrl);
        // Simulate a delay for loading the image
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image loaded from " + imageUrl);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + imageUrl);
    }
}

class ProxyImage implements Image {
    private String imageUrl;
    private RealImage realImage;

    public ProxyImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imageUrl);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("http://example.com/image1.jpg");
        Image image2 = new ProxyImage("http://example.com/image2.jpg");

        image1.display();
        System.out.println();
        image2.display();
        System.out.println();

        image1.display();
        System.out.println();
        image2.display();
    }
}
