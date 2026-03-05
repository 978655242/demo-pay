import base64
import codecs

class Base64:
    @staticmethod
    def get_base64(s):
        if s is None:
            return None
        return Base64.get_base64_from_bytes(s.encode('utf-8'))

    @staticmethod
    def get_base64_from_bytes(b):
        rb = base64.b64encode(b)
        if rb is None:
            return None
        return rb.decode('utf-8')

    @staticmethod
    def get_from_base64(s):
        if s is None:
            return None
        b = Base64.get_bytes_from_base64(s)
        if b is None:
            return None
        return b.decode('utf-8')

    @staticmethod
    def get_bytes_from_base64(s):
        if s is None:
            return None
        b = base64.b64decode(s.encode('utf-8'))
        return b