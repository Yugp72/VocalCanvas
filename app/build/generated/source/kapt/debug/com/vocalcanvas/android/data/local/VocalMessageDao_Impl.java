package com.vocalcanvas.android.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.vocalcanvas.android.model.MessageType;
import com.vocalcanvas.android.model.VocalMessage;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VocalMessageDao_Impl implements VocalMessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<VocalMessage> __insertionAdapterOfVocalMessage;

  private final EntityDeletionOrUpdateAdapter<VocalMessage> __deletionAdapterOfVocalMessage;

  private final EntityDeletionOrUpdateAdapter<VocalMessage> __updateAdapterOfVocalMessage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMessages;

  public VocalMessageDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVocalMessage = new EntityInsertionAdapter<VocalMessage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `vocal_messages` (`id`,`content`,`type`,`timestamp`,`xPosition`,`yPosition`,`isAiResponse`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VocalMessage entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getContent() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContent());
        }
        statement.bindString(3, __MessageType_enumToString(entity.getType()));
        statement.bindLong(4, entity.getTimestamp());
        statement.bindDouble(5, entity.getXPosition());
        statement.bindDouble(6, entity.getYPosition());
        final int _tmp = entity.isAiResponse() ? 1 : 0;
        statement.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfVocalMessage = new EntityDeletionOrUpdateAdapter<VocalMessage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `vocal_messages` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VocalMessage entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfVocalMessage = new EntityDeletionOrUpdateAdapter<VocalMessage>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `vocal_messages` SET `id` = ?,`content` = ?,`type` = ?,`timestamp` = ?,`xPosition` = ?,`yPosition` = ?,`isAiResponse` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VocalMessage entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getContent() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContent());
        }
        statement.bindString(3, __MessageType_enumToString(entity.getType()));
        statement.bindLong(4, entity.getTimestamp());
        statement.bindDouble(5, entity.getXPosition());
        statement.bindDouble(6, entity.getYPosition());
        final int _tmp = entity.isAiResponse() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllMessages = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM vocal_messages";
        return _query;
      }
    };
  }

  @Override
  public Single<Long> insertMessage(final VocalMessage message) {
    return Single.fromCallable(new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfVocalMessage.insertAndReturnId(message);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<List<Long>> insertMessages(final List<VocalMessage> messages) {
    return Single.fromCallable(new Callable<List<Long>>() {
      @Override
      @Nullable
      public List<Long> call() throws Exception {
        __db.beginTransaction();
        try {
          final List<Long> _result = __insertionAdapterOfVocalMessage.insertAndReturnIdsList(messages);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> deleteMessage(final VocalMessage message) {
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __deletionAdapterOfVocalMessage.handle(message);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> updateMessage(final VocalMessage message) {
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total += __updateAdapterOfVocalMessage.handle(message);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Single<Integer> deleteAllMessages() {
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      @Nullable
      public Integer call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMessages.acquire();
        try {
          __db.beginTransaction();
          try {
            final Integer _result = _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return _result;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllMessages.release(_stmt);
        }
      }
    });
  }

  @Override
  public Observable<List<VocalMessage>> getAllMessages() {
    final String _sql = "SELECT * FROM vocal_messages ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createObservable(__db, false, new String[] {"vocal_messages"}, new Callable<List<VocalMessage>>() {
      @Override
      @NonNull
      public List<VocalMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfXPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "xPosition");
          final int _cursorIndexOfYPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "yPosition");
          final int _cursorIndexOfIsAiResponse = CursorUtil.getColumnIndexOrThrow(_cursor, "isAiResponse");
          final List<VocalMessage> _result = new ArrayList<VocalMessage>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VocalMessage _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final MessageType _tmpType;
            _tmpType = __MessageType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpXPosition;
            _tmpXPosition = _cursor.getFloat(_cursorIndexOfXPosition);
            final float _tmpYPosition;
            _tmpYPosition = _cursor.getFloat(_cursorIndexOfYPosition);
            final boolean _tmpIsAiResponse;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAiResponse);
            _tmpIsAiResponse = _tmp != 0;
            _item = new VocalMessage(_tmpId,_tmpContent,_tmpType,_tmpTimestamp,_tmpXPosition,_tmpYPosition,_tmpIsAiResponse);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<VocalMessage> getMessageById(final long id) {
    final String _sql = "SELECT * FROM vocal_messages WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return RxRoom.createSingle(new Callable<VocalMessage>() {
      @Override
      @Nullable
      public VocalMessage call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfXPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "xPosition");
          final int _cursorIndexOfYPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "yPosition");
          final int _cursorIndexOfIsAiResponse = CursorUtil.getColumnIndexOrThrow(_cursor, "isAiResponse");
          final VocalMessage _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final MessageType _tmpType;
            _tmpType = __MessageType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final float _tmpXPosition;
            _tmpXPosition = _cursor.getFloat(_cursorIndexOfXPosition);
            final float _tmpYPosition;
            _tmpYPosition = _cursor.getFloat(_cursorIndexOfYPosition);
            final boolean _tmpIsAiResponse;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAiResponse);
            _tmpIsAiResponse = _tmp != 0;
            _result = new VocalMessage(_tmpId,_tmpContent,_tmpType,_tmpTimestamp,_tmpXPosition,_tmpYPosition,_tmpIsAiResponse);
          } else {
            _result = null;
          }
          if (_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __MessageType_enumToString(@NonNull final MessageType _value) {
    switch (_value) {
      case FINANCIAL_DATA: return "FINANCIAL_DATA";
      case AI_RESPONSE: return "AI_RESPONSE";
      case USER_INPUT: return "USER_INPUT";
      case SYSTEM_NOTIFICATION: return "SYSTEM_NOTIFICATION";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private MessageType __MessageType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "FINANCIAL_DATA": return MessageType.FINANCIAL_DATA;
      case "AI_RESPONSE": return MessageType.AI_RESPONSE;
      case "USER_INPUT": return MessageType.USER_INPUT;
      case "SYSTEM_NOTIFICATION": return MessageType.SYSTEM_NOTIFICATION;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
