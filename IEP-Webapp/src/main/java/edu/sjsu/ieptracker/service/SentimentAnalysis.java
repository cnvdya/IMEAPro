package edu.sjsu.ieptracker.service;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.comprehend.model.SentimentScore;
import edu.sjsu.ieptracker.dto.EvaluationDto;
import org.springframework.stereotype.Service;

@Service
public class SentimentAnalysis {

    public EvaluationDto detectSentiment(EvaluationDto evaluationDto){


//        String text = evaluationDto.getComments();
        String text = evaluationDto.getComments();

        AWSCredentials awsCreds;

        try {
            awsCreds = new BasicAWSCredentials("", "");
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (/Users/userid/.aws/credentials), and is in valid format.",
                    e);
        }

        AmazonComprehend comprehendClient =
                AmazonComprehendClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                        .withRegion("region")
                        .build();

        System.out.println("Calling DetectSentiment");
        DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
                .withLanguageCode("en");
        DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);
        System.out.println(detectSentimentResult);
        System.out.println("End of DetectSentiment\n");
        System.out.println( "Done" );
        SentimentScore sentimentScore = detectSentimentResult.getSentimentScore();
        String sentiment = detectSentimentResult.getSentiment();
        evaluationDto.setPositiveScore(sentimentScore.getPositive().toString());
        evaluationDto.setNegativeScore(sentimentScore.getNegative().toString());
        evaluationDto.setAverageScore(detectSentimentResult.getSentiment());
        if(sentiment.equals("POSITIVE")|| sentiment.equals("NEUTRAL")){
            evaluationDto.setPassed(1);
        }
        return evaluationDto;
    }
}
