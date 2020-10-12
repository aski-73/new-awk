/* Generated By:JavaCC: Do not edit this line. NawkParserTokenManager.java */
package interpreter;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;
import interpreter.ast.*;
import interpreter.errors.*;

/** Token Manager. */
public class NawkParserTokenManager implements NawkParserConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x79ff0000000L) != 0L)
         {
            jjmatchedKind = 47;
            return 7;
         }
         return -1;
      case 1:
         if ((active0 & 0x59ff0000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 1;
            return 7;
         }
         if ((active0 & 0x20000000000L) != 0L)
            return 7;
         return -1;
      case 2:
         if ((active0 & 0x59fd0000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 2;
            return 7;
         }
         if ((active0 & 0x20000000L) != 0L)
            return 7;
         return -1;
      case 3:
         if ((active0 & 0x40700000000L) != 0L)
            return 7;
         if ((active0 & 0x198d0000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 3;
            return 7;
         }
         return -1;
      case 4:
         if ((active0 & 0x18800000000L) != 0L)
            return 7;
         if ((active0 & 0x10d0000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 4;
            return 7;
         }
         return -1;
      case 5:
         if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 47;
            jjmatchedPos = 5;
            return 7;
         }
         if ((active0 & 0x1050000000L) != 0L)
            return 7;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 11;
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 37:
         return jjStopAtPos(0, 8);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 40:
         return jjStopAtPos(0, 20);
      case 41:
         return jjStopAtPos(0, 21);
      case 42:
         return jjStopAtPos(0, 6);
      case 43:
         jjmatchedKind = 2;
         return jjMoveStringLiteralDfa1_0(0x8L);
      case 44:
         return jjStopAtPos(0, 27);
      case 45:
         jjmatchedKind = 4;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 46:
         return jjStopAtPos(0, 37);
      case 47:
         return jjStopAtPos(0, 7);
      case 58:
         return jjStopAtPos(0, 38);
      case 59:
         return jjStopAtPos(0, 26);
      case 60:
         jjmatchedKind = 13;
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 61:
         jjmatchedKind = 10;
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 62:
         jjmatchedKind = 12;
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 64:
         return jjStopAtPos(0, 1);
      case 91:
         return jjStopAtPos(0, 24);
      case 93:
         return jjStopAtPos(0, 25);
      case 94:
         return jjStopAtPos(0, 9);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x100000000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x20020000000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x1000000000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 123:
         return jjStopAtPos(0, 22);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 125:
         return jjStopAtPos(0, 23);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(1, 19);
         break;
      case 43:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(1, 3);
         break;
      case 45:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      case 61:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(1, 14);
         else if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         else if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(1, 16);
         else if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000000L);
      case 102:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 41, 7);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x10100000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x290000000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x8400000000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000000L);
      case 124:
         if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(1, 18);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x18200000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000000L);
      case 116:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(2, 29, 7);
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x410000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 100:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 33, 7);
         break;
      case 101:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 7);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 42, 7);
         break;
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x10080000000L);
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000L);
      case 114:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 32, 7);
         break;
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(4, 35, 7);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 40, 7);
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 108:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x40000000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000L);
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 39, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000L);
      case 101:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 7);
         break;
      case 103:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(5, 30, 7);
         break;
      case 110:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 36, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(6, 31, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 14;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 43)
                        kind = 43;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 43)
                        kind = 43;
                     jjCheckNAdd(9);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  else if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 2:
                  if (curChar == 39 && kind > 45)
                     kind = 45;
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 4:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 34 && kind > 46)
                     kind = 46;
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if (curChar != 48)
                     break;
                  if (kind > 43)
                     kind = 43;
                  jjCheckNAdd(9);
                  break;
               case 9:
                  if (curChar != 46)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAdd(10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 44)
                     kind = 44;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  jjCheckNAddStates(0, 2);
                  break;
               case 12:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 43)
                     kind = 43;
                  jjCheckNAdd(12);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 9);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 7:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 47)
                     kind = 47;
                  jjCheckNAdd(7);
                  break;
               case 1:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  jjAddStates(3, 4);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(3, 4);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 14 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   12, 13, 9, 4, 5, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\100", "\53", "\53\53", "\55", "\55\55", "\52", "\57", "\45", "\136", 
"\75", "\41", "\76", "\74", "\75\75", "\74\75", "\76\75", "\41\75", "\174\174", 
"\46\46", "\50", "\51", "\173", "\175", "\133", "\135", "\73", "\54", 
"\144\157\165\142\154\145", "\151\156\164", "\163\164\162\151\156\147", "\142\157\157\154\145\141\156", 
"\143\150\141\162", "\166\157\151\144", "\164\162\165\145", "\146\141\154\163\145", 
"\162\145\164\165\162\156", "\56", "\72", "\160\162\151\156\164", "\167\150\151\154\145", "\151\146", 
"\145\154\163\145", null, null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xffffffffffffL, 
};
static final long[] jjtoSkip = {
   0x7000000000000L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[14];
private final int[] jjstateSet = new int[28];
protected char curChar;
/** Constructor. */
public NawkParserTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public NawkParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 14; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   t.image = curTokenImage;

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000200L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedPos == 0 && jjmatchedKind > 50)
   {
      jjmatchedKind = 50;
   }
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
