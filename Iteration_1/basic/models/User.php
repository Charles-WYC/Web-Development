<?php

namespace app\models;

use Yii;

/**
 * This is the model class for table "user".
 *
 * @property string $username
 * @property string $password
 * @property string $identity
 * @property string $id
 * @property string $authKey
 * @property string $accessToken
 * @property string $mail_address
 *
 * @property Indent[] $indents
 * @property UserDetail $userDetail
 */
class User extends \yii\db\ActiveRecord implements \yii\web\IdentityInterface
{
    /**
     * @inheritdoc
     */
    public static function tableName()
    {
        return 'user';
    }

    /**
     * @inheritdoc
     */
    public function rules()
    {
        return [
            [['username'], 'required'],
            [['username', 'password', 'id', 'authKey', 'accessToken'], 'string', 'max' => 20],
            [['identity'], 'string', 'max' => 14],
            [['mail_address'], 'string', 'max' => 100],
        ];
    }

    /**
     * @inheritdoc
     */
    public function attributeLabels()
    {
        return [
            'username' => 'Username',
            'password' => 'Password',
            'identity' => 'Identity',
            'id' => 'ID',
            'authKey' => 'Auth Key',
            'accessToken' => 'Access Token',
            'mail_address' => 'Mail Address',
        ];
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getIndents()
    {
        return $this->hasMany(Indent::className(), ['username' => 'username']);
    }

    /**
     * @return \yii\db\ActiveQuery
     */
    public function getUserDetail()
    {
        return $this->hasOne(UserDetail::className(), ['username' => 'username']);
    }
	
	/**
     * Finds user by username
     *
     * @param  string      $username
     * @return static|null
     */
    public static function findByUsername($username)
    {

		$command = \Yii::$app->db->createCommand('select * from user');
		$rows = $command->queryAll();
        foreach ($rows as $user) {
            if (strcasecmp($user['username'], $username) === 0) {
                return new static($user);
            }
        }

        return null;
    }
	
	/**
     * Validates password
     *
     * @param  string  $password password to validate
     * @return boolean if password provided is valid for current user
     */
    public function validatePassword($password)
    {
        return $this->password === $password;
    }
	
	
	public static function findIdentity($id)
	{
		$command = \Yii::$app->db->createCommand('select * from user');
		$rows = $command->queryAll();
        foreach ($rows as $user) {
            if (strcasecmp($user['id'], $id) === 0) {
                return new static($user);
            }
        }

        return null;
	}
	
	public static function findIdentityByAccessToken($token, $type = null)
	{
		$command = \Yii::$app->db->createCommand('select * from user');
		$rows = $command->queryAll();
        foreach ($rows as $user) {
            if (strcasecmp($user['accessToken'], $token) === 0) {
                return new static($user);
            }
        }

        return null;
	}
	    
	/**
     * @inheritdoc
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @inheritdoc
     */
    public function getAuthKey()
    {
        return $this->authKey;
    }

    /**
     * @inheritdoc
     */
    public function validateAuthKey($authKey)
    {
        return $this->authKey === $authKey;
    }
}
