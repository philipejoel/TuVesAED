import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import exceptions.AlreadyFavouriteException;
import exceptions.AlreadyHasTagException;
import exceptions.DisabledVideoException;
import exceptions.EmptyHistoryException;
import exceptions.InvalidLengthException;
import exceptions.NoFavouriteVideoException;
import exceptions.NoFavouritesException;
import exceptions.NoSuchTagException;
import exceptions.NoSuchUserException;
import exceptions.NoSuchVideoException;
import exceptions.NoTagsInVideoException;
import tuVes.PlayerClass;
import tuVes.Video;;

//INCLUDE ALL SUCCESS MESSAGES, LISTS, ETC
public class Main {
	
	private static final String INSERT_USER = "IU";
	private static final String INSERT_VIDEO = "IV";
	private static final String DISABLE_VIDEO = "DV"; 
	private static final String PLAY_VIDEO = "VV";  
	private static final String HISTORY_LIST = "LH";
	private static final String REMOVE_HISTORY = "RH";
	private static final String ADD_VIDEO_TO_FAVOURITES = "FV";
	private static final String REMOVE_VIDEO_FROM_FAVOURITE = "RV";
	private static final String FAVOURITE_LIST = "LF";
	private static final String ADD_TAG_TO_VIDEO = "TV";
	private static final String VIDEO_TAG_LIST = "LT";
	private static final String SEARCH_TAG = "PV";
	private static final String EXIT = "XS";

	//Constants for messages
	private static final String USER_INSERT_SUCCESS = "Insercao de utilizador com sucesso.";
	private static final String USER_EXISTS = "Utilizador existente.";
	private static final String VIDEO_INSERT_SUCCESS = "Video adicionado com sucesso.";
	private static final String VIDEO_EXISTS = "Video existente.";
	private static final String NICK_EXISTS = "Nick existente.";
	private static final String INVALID_LENGTH = "Duracao invalida.";
	private static final String VIDEO_DISABLE_SUCCESS = "Video desativado com sucesso.";
	private static final String VIDEO_DOES_NOT_EXIST = "Video inexistente.";
	private static final String DISABLED_VIDEO = "Video inativo.";
	private static final String VIDEO_WATCHED_SUCCESS = "Video visualizado com sucesso.";
	private static final String NICK_DOES_NOT_EXIST = "Nick inexistente.";
	private static final String NO_HISTORY = "Historico vazio.";
	private static final String EMPTY_HISTORY_SUCCESS = "Limpeza de historico efetuada com sucesso.";
	private static final String ADD_VIDEO_TO_FAVOURITES_SUCCESS = "Video adicionado a favoritos com sucesso.";
	private static final String VIDEO_ALREADY_USER_FAVOURITE = "Video ja e favorito de nick.";
	private static final String VIDEO_REMOVE_FROM_FAVOURITE_SUCCESS = "Video removido de favoritos com sucesso.";
	private static final String VIDEO_NOT_USER_FAVOURITE = "Video nao e facorito do nick.";
	private static final String USER_HAS_NO_FAVOURITES = "Utilizador nao tem favoritos.";
	private static final String TAG_ADD_TO_VIDEO_SUCCESS = "Tag adicionada a video com sucesso.";
	private static final String VIDEO_ALREADY_HAS_TAG = "Video ja tem tag.";
	private static final String VIDEO_HAS_NO_TAGS = "Video nao tem tags.";
	private static final String TAG_DOES_NOT_EXIST = "Tag inexistente.";
	private static final String EXIT_MESSAGE = "Gravando e terminando...";
	private static final String DATA_FILE = "TuVes.dat";
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PlayerClass p = new PlayerClass();
		try {
			p.load(DATA_FILE);
		} catch (ClassNotFoundException | IOException e) {
		}
		commandInterpreter(in, p);
		in.close();
	}

	
	private static void commandInterpreter(Scanner in, PlayerClass p) {
		String command = null;
		do {			
			command = in.next();
			switch(command.toUpperCase()) {
				case INSERT_USER: processInsertUser(in, p); break;
				case INSERT_VIDEO: processInsertVideo(in, p); break;
				case DISABLE_VIDEO: processDisableVideo(in, p); break;
				case PLAY_VIDEO: processPlayVideo(in, p); break;
				case HISTORY_LIST: processHistoryList(in, p); break;
				case REMOVE_HISTORY: processRemoveHistory(in, p); break;
				case ADD_VIDEO_TO_FAVOURITES: processAddVideoToFavourites(in, p); break;
				case REMOVE_VIDEO_FROM_FAVOURITE: processRemoveVideoFromFavourites(in, p); break;
				case FAVOURITE_LIST: processFavouriteList(in, p); break;
				case ADD_TAG_TO_VIDEO: processAddTagToVideo(in, p); break;
				case VIDEO_TAG_LIST: processVideoTagList(in, p); break;
				case SEARCH_TAG: processSearchTag(in, p); break;
				case EXIT: processExit(p); break;
				default: break;
			}
			System.out.println();	
		}
		while (!command.equals(EXIT));
	}
	
	private static void	 processInsertUser(Scanner in, PlayerClass p) {
		String nick = in.next();
		String email = in.next();
		String name = in.nextLine();
		p.insertUser(nick, email, name);
		System.out.println(USER_INSERT_SUCCESS);
	}
	private static void	 processInsertVideo(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		String nick = in.next();
		String url = in.next();
		long length = in.nextInt();
		String title = in.nextLine().replaceAll("^ *", "");
		try {
			p.insertVideo(idVideo, nick, url, length, title);
			System.out.println(VIDEO_INSERT_SUCCESS);
		} catch (NoSuchUserException e) {
			System.out.println(NICK_DOES_NOT_EXIST);
		} catch (InvalidLengthException e) {
			System.out.println(INVALID_LENGTH);
		}
	}
	private static void	 processDisableVideo(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		try {
			p.disableVideo(idVideo);
			System.out.println(VIDEO_DISABLE_SUCCESS);
		} catch (NoSuchVideoException e) {
			System.out.println(VIDEO_DOES_NOT_EXIST);
		} catch (DisabledVideoException e) {
			System.out.println(DISABLED_VIDEO);
		}
	}
	private static void	 processPlayVideo(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		String nick = in.next();
		try {
			p.playVideo(idVideo, nick);
			System.out.println(VIDEO_WATCHED_SUCCESS);
		} catch (NoSuchVideoException e) {
			System.out.println(VIDEO_DOES_NOT_EXIST);
		} catch (NoSuchUserException e) {
			System.out.println(NICK_DOES_NOT_EXIST);
		} catch (DisabledVideoException e) {
			System.out.println(DISABLED_VIDEO);
		}
	}
	private static void	 processHistoryList(Scanner in, PlayerClass p) {
		String nick = in.next();
		try{
			@SuppressWarnings("unchecked")
			Iterator<Video> historyIterator = (Iterator<Video>) p.listHistory(nick);
			while (historyIterator.hasNext()){
				System.out.println(historyIterator.next().getVideoInfo());
			}
		}
		catch (NoSuchUserException e){
			System.out.println(NICK_DOES_NOT_EXIST);
		}
		catch (EmptyHistoryException e){
			System.out.println(NO_HISTORY);
		}
	}
	private static void	 processRemoveHistory(Scanner in, PlayerClass p) {
		String nick = in.next();
		try{
			p.removeHistory(nick);
			System.out.println(EMPTY_HISTORY_SUCCESS);
		}
		catch(NoSuchUserException e){
			System.out.println(NICK_DOES_NOT_EXIST);
		}
	}
	private static void	 processAddVideoToFavourites(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		String nick = in.next();
		try{
			p.addVideoToFavourites(idVideo, nick);
			System.out.println(ADD_VIDEO_TO_FAVOURITES_SUCCESS);
		}
		catch(NoSuchVideoException e){
			System.out.println(VIDEO_DOES_NOT_EXIST);
		}
		catch(NoSuchUserException e){
			System.out.println(NICK_DOES_NOT_EXIST);
		}
		catch(DisabledVideoException e){
			System.out.println(DISABLED_VIDEO);
		}
		catch(AlreadyFavouriteException e){
			System.out.println(VIDEO_ALREADY_USER_FAVOURITE);
		}
	}
	private static void	 processRemoveVideoFromFavourites(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		String nick = in.next();
		try{
			p.removeVideoFromFavourites(idVideo, nick);
			System.out.println(VIDEO_REMOVE_FROM_FAVOURITE_SUCCESS);
		}
		catch(NoSuchVideoException e){
			System.out.println(VIDEO_DOES_NOT_EXIST);
		}
		catch(NoSuchUserException e){
			System.out.println(NICK_DOES_NOT_EXIST);
		}
		catch(NoFavouriteVideoException  e){
			System.out.println(VIDEO_NOT_USER_FAVOURITE);
		}
	}
	private static void	 processFavouriteList(Scanner in, PlayerClass p) {
		String nick = in.next();
		try{
			System.out.println(p.listFavourites(nick));			
		}
		catch(NoSuchUserException e){
			System.out.println(NICK_DOES_NOT_EXIST);
		}
		catch(NoFavouritesException e){
			System.out.println(USER_HAS_NO_FAVOURITES);
		}
	}
	private static void	 processAddTagToVideo(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		String tag = in.next();
		try{
			p.addTagToVideo(idVideo, tag);
			System.out.println(TAG_ADD_TO_VIDEO_SUCCESS);
		}
		catch(NoSuchVideoException e ){
			System.out.println(VIDEO_DOES_NOT_EXIST);
		}
		catch(AlreadyHasTagException e ){
			System.out.println(VIDEO_ALREADY_HAS_TAG);
		}
		catch(DisabledVideoException e){
			System.out.println(DISABLED_VIDEO);
		}
	}
	private static void	 processVideoTagList(Scanner in, PlayerClass p) {
		String idVideo = in.next();
		try{
			System.out.println(p.listTags(idVideo)+"\n");
		}
		catch(NoSuchVideoException e){
			System.out.println(VIDEO_DOES_NOT_EXIST);
		}
		catch(NoTagsInVideoException e){
			System.out.println(VIDEO_HAS_NO_TAGS);
		}
	}
	private static void	 processSearchTag(Scanner in, PlayerClass p) {
		String tag = in.next();
		try{
			System.out.println(p.searchTag(tag));
		}
		catch(NoSuchTagException e){
			System.out.println(TAG_DOES_NOT_EXIST);
		}
	}
	private static void processExit(PlayerClass p){
		try {
			p.save(DATA_FILE);
			System.out.println(EXIT_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
