import se.iths.provider.Character;
import se.iths.provider.Sentence;
import se.iths.provider.Word;
import se.iths.service.StringCalculator;

module TextProvider {
    requires TextService;
    exports se.iths.provider;
    provides StringCalculator with Character, Sentence, Word;
}
